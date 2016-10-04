package mongoose.activities.shared.logic.time;

import naga.commons.util.Dates;
import naga.commons.util.Numbers;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.concurrent.TimeUnit;

/**
 * @author Bruno Salmon
 */
class TimeConverter {

    static long convertTime(long time, TimeUnit srcTu, TimeUnit dstTu) {
        if (srcTu == dstTu)
            return time;
        return dstTu.convert(time, srcTu);
    }

    static long convertExcludedEnd(long end, TimeUnit srcTu, TimeUnit dstTu) {
        if (dstTu == TimeUnit.DAYS && srcTu.compareTo(dstTu) < 0)
            end = end + oneDay(srcTu) - 1;
        return convertTime(end, srcTu, dstTu);
    }

    static long oneDay(TimeUnit timeUnit) {
        return convertTime(1, TimeUnit.DAYS, timeUnit);
    }

    static long floorToDay(long time, TimeUnit timeUnit) {
        if (timeUnit == TimeUnit.DAYS)
            return time;
        return convertTime(convertTime(time, timeUnit, TimeUnit.DAYS), TimeUnit.DAYS, timeUnit);
    }

    static String formatTime(long time, TimeUnit timeUnit, boolean excluded) {
        long epochMillis = convertTime(time, timeUnit, TimeUnit.MILLISECONDS);
        LocalDateTime date = Dates.epochMillisUtcToLocalDateTime(epochMillis);
        String format = "dd/MM/yyyy HH:mm";
        if (date.getYear() == 1970)
            format = "HH:mm";
        else if (date.getHour() == 0 && date.getMinute() == 0) {
            format = "dd/MM/yyyy";
            if (excluded)
                date = date.minusDays(1);
        }
        return Dates.format(date, format);
    }

    static long parseTime(String text, TimeUnit timeUnit, boolean excluded) {
        // Only accepted format is DMY [DD/MM/YYYY] [hh:mm:ss]
        LocalDateTime dateTime = parseDMYLocalDateTime(text, excluded);
        long epochMillis = Dates.localDateTimeToEpochMillisUtc(dateTime);
        return excluded ?
                convertExcludedEnd(epochMillis, TimeUnit.MILLISECONDS, timeUnit) :
                convertTime(epochMillis, TimeUnit.MILLISECONDS, timeUnit);
    }

    private static LocalDateTime parseDMYLocalDateTime(String text, boolean excluded) {
        text = text.trim();
        int day = 1, month = 1, year = 1970, hour = 0, minute = 0, second = 0;
        int p = 0;
        int i = text.indexOf('/', p);
        if (i != -1) {
            day = Numbers.intValue(text.substring(p, i));
            i = text.indexOf('/', p = i + 1);
            if (i != -1) {
                month = Numbers.intValue(text.substring(p, i));
                i = text.indexOf(' ', p = i + 1);
                if (i == -1)
                    i = text.length();
                year = Numbers.intValue(text.substring(p, i));
                p = i + 1;
            }
        }
        i = text.indexOf(':', p);
        if (i == -1)
            i = text.indexOf('h', p);
        if (i != -1) {
            hour = Numbers.intValue(text.substring(p, i));
            if (hour > 24) {
                day++;
                hour -= 24;
            }
            i = text.indexOf(':', p = i + 1);
            if (i == -1)
                i = text.length();
            minute = Numbers.intValue(text.substring(p, i));
            if (i < text.length()) {
                p = i + 1;
                i = text.length();
                second = Numbers.intValue(text.substring(p, i));
            }
        } else if (excluded)
            day++;
        return LocalDateTime.of(year, Month.of(month), day, hour, minute, second);
    }
}