/* The following code was generated by JFlex 1.6.1 */


/* --------------------------Usercode Section------------------------ */

package webfx.framework.expression.parser.jflex;

import java_cup.runtime.*;
import webfx.framework.expression.parser.javacup.ExpressionSymbols;
import static webfx.framework.expression.parser.javacup.ExpressionSymbols.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>C:/dev/git-repos/webfx/webfx/webfx-framework/src/main/java/webfx/framework/expression/parser/jflex/ExpressionLexer.flex</tt>
 */
public class ExpressionLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING_SINGLE_QUOTE = 2;
  public static final int STRING_DOUBLE_QUOTE = 4;
  public static final int STRING_GRAVE_ACCENT = 6;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3, 3
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\103\1\104\1\1\22\0\1\3\1\76\1\10"+
    "\3\0\1\100\1\7\1\62\1\63\1\14\1\72\1\66\1\73\1\67"+
    "\1\13\1\4\3\102\4\15\2\5\1\55\1\0\1\75\1\56\1\74"+
    "\1\77\1\0\1\6\1\23\1\6\1\25\1\26\1\6\1\16\7\6"+
    "\1\20\1\22\1\6\1\17\1\61\1\6\1\21\3\6\1\24\1\6"+
    "\1\64\1\11\1\65\1\0\1\6\1\12\1\45\1\57\1\32\1\34"+
    "\1\30\1\37\1\47\1\44\1\35\1\60\1\52\1\31\1\42\1\36"+
    "\1\41\1\54\1\6\1\40\1\27\1\33\1\50\1\46\1\43\1\51"+
    "\1\53\1\6\1\70\1\101\1\71\7\0\1\103\u1fa2\0\1\103\1\103"+
    "\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\4\0\1\1\2\2\2\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\16\4\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\2\1\1\32\2\33\1\34\1\1"+
    "\2\32\1\2\1\0\12\4\1\35\1\36\6\4\1\37"+
    "\3\4\1\40\2\4\1\41\1\42\1\43\1\44\1\45"+
    "\1\37\1\46\1\47\1\50\1\51\1\52\1\47\1\53"+
    "\1\54\1\55\1\56\1\57\2\0\15\4\1\30\7\4"+
    "\1\60\1\61\1\45\1\62\1\47\1\0\6\4\1\63"+
    "\1\64\1\65\1\66\1\67\2\4\1\70\1\4\1\71"+
    "\10\4\1\0\1\72\1\4\1\73\1\74\1\75\1\76"+
    "\1\4\1\77\1\4\2\0\1\100\1\101\1\102\2\4"+
    "\1\103\2\0\2\4\1\104\1\105\1\106\1\107";

  private static int [] zzUnpackAction() {
    int [] result = new int[177];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\105\0\212\0\317\0\u0114\0\u0159\0\u0114\0\u0114"+
    "\0\u019e\0\u01e3\0\u0114\0\u0114\0\u0114\0\u0228\0\u0114\0\u026d"+
    "\0\u02b2\0\u02f7\0\u033c\0\u0381\0\u03c6\0\u040b\0\u0450\0\u0495"+
    "\0\u04da\0\u051f\0\u0564\0\u05a9\0\u05ee\0\u0114\0\u0633\0\u0114"+
    "\0\u0114\0\u0114\0\u0114\0\u0114\0\u0114\0\u0114\0\u0114\0\u0114"+
    "\0\u0114\0\u0678\0\u06bd\0\u0702\0\u0114\0\u0747\0\u078c\0\u07d1"+
    "\0\u0816\0\u0114\0\u0114\0\u085b\0\u08a0\0\u08e5\0\u092a\0\u096f"+
    "\0\u09b4\0\u09f9\0\u0a3e\0\u0a83\0\u0ac8\0\u0b0d\0\u0b52\0\u0b97"+
    "\0\u0bdc\0\u0c21\0\u01e3\0\u01e3\0\u0c66\0\u0cab\0\u0cf0\0\u0d35"+
    "\0\u0d7a\0\u0dbf\0\u09f9\0\u0e04\0\u0e49\0\u0e8e\0\u0ed3\0\u0f18"+
    "\0\u0f5d\0\u0114\0\u0114\0\u0114\0\u0114\0\u0114\0\u0114\0\u0114"+
    "\0\u0fa2\0\u0114\0\u0114\0\u0114\0\u0fe7\0\u0114\0\u0114\0\u0114"+
    "\0\u0114\0\u0114\0\u102c\0\u1071\0\u10b6\0\u10fb\0\u1140\0\u1185"+
    "\0\u11ca\0\u120f\0\u1254\0\u1299\0\u12de\0\u1323\0\u1368\0\u13ad"+
    "\0\u13f2\0\u01e3\0\u1437\0\u147c\0\u14c1\0\u1506\0\u154b\0\u1590"+
    "\0\u15d5\0\u01e3\0\u01e3\0\u01e3\0\u01e3\0\u0114\0\u161a\0\u165f"+
    "\0\u16a4\0\u16e9\0\u172e\0\u1773\0\u17b8\0\u01e3\0\u01e3\0\u01e3"+
    "\0\u01e3\0\u01e3\0\u17fd\0\u1842\0\u1887\0\u18cc\0\u01e3\0\u1911"+
    "\0\u1956\0\u199b\0\u19e0\0\u1a25\0\u1a6a\0\u1aaf\0\u1af4\0\u1b39"+
    "\0\u01e3\0\u1b7e\0\u01e3\0\u01e3\0\u01e3\0\u01e3\0\u1bc3\0\u01e3"+
    "\0\u1c08\0\u1c4d\0\u1c92\0\u01e3\0\u01e3\0\u0114\0\u1cd7\0\u1d1c"+
    "\0\u01e3\0\u1d61\0\u1da6\0\u1deb\0\u1e30\0\u0114\0\u0114\0\u01e3"+
    "\0\u01e3";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[177];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\5\1\6\2\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\5\1\15\1\16\1\17\1\11\1\20\1\12\1\21"+
    "\6\12\1\22\1\23\1\24\1\12\1\25\1\26\1\27"+
    "\1\30\1\31\1\12\1\32\1\12\1\33\1\34\1\35"+
    "\1\12\1\20\5\12\1\36\1\37\3\12\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51"+
    "\1\52\1\53\1\54\1\55\1\56\1\57\1\11\1\5"+
    "\1\7\1\60\1\61\1\62\4\60\1\63\1\60\1\64"+
    "\73\60\1\65\1\61\1\62\5\65\1\63\1\64\73\65"+
    "\1\66\1\61\1\62\6\66\1\64\1\63\72\66\107\0"+
    "\1\7\106\0\2\11\7\0\1\11\64\0\1\11\6\0"+
    "\3\12\6\0\40\12\2\0\3\12\20\0\1\12\15\0"+
    "\1\67\1\70\74\0\3\12\6\0\2\12\1\71\20\12"+
    "\1\71\14\12\2\0\3\12\20\0\1\12\6\0\3\12"+
    "\6\0\2\12\1\72\20\12\1\72\14\12\2\0\3\12"+
    "\20\0\1\12\6\0\3\12\6\0\13\12\1\73\24\12"+
    "\2\0\3\12\20\0\1\12\6\0\3\12\6\0\34\12"+
    "\1\74\3\12\2\0\3\12\20\0\1\12\6\0\3\12"+
    "\6\0\20\12\1\75\7\12\1\76\7\12\2\0\3\12"+
    "\20\0\1\12\6\0\3\12\6\0\23\12\1\77\3\12"+
    "\1\100\10\12\2\0\3\12\20\0\1\12\6\0\3\12"+
    "\6\0\13\12\1\101\4\12\1\102\17\12\2\0\3\12"+
    "\20\0\1\12\6\0\3\12\6\0\12\12\1\103\6\12"+
    "\1\104\3\12\1\105\12\12\2\0\3\12\20\0\1\12"+
    "\6\0\3\12\6\0\24\12\1\106\6\12\1\107\4\12"+
    "\2\0\3\12\20\0\1\12\6\0\3\12\6\0\20\12"+
    "\1\110\2\12\1\111\4\12\1\112\7\12\2\0\3\12"+
    "\20\0\1\12\6\0\3\12\6\0\2\12\1\72\20\12"+
    "\1\113\14\12\2\0\1\114\2\12\20\0\1\12\6\0"+
    "\3\12\6\0\27\12\1\115\10\12\2\0\3\12\20\0"+
    "\1\12\6\0\3\12\6\0\30\12\1\116\7\12\2\0"+
    "\3\12\20\0\1\12\6\0\3\12\6\0\12\12\1\117"+
    "\1\12\1\120\4\12\1\121\16\12\2\0\3\12\20\0"+
    "\1\12\60\0\1\122\104\0\1\123\104\0\1\124\15\0"+
    "\1\125\66\0\1\125\126\0\1\126\105\0\1\127\3\0"+
    "\1\60\2\0\4\60\1\0\1\60\1\0\73\60\2\0"+
    "\1\62\102\0\1\130\2\0\1\130\1\131\2\130\1\132"+
    "\1\133\1\134\3\130\1\135\15\130\1\136\2\130\1\137"+
    "\1\140\1\141\16\130\1\142\22\130\1\131\2\0\1\65"+
    "\2\0\5\65\2\0\73\65\1\66\2\0\6\66\2\0"+
    "\72\66\1\67\1\6\1\7\102\67\14\143\1\144\70\143"+
    "\4\0\3\12\6\0\3\12\1\145\20\12\1\145\13\12"+
    "\2\0\3\12\20\0\1\12\6\0\3\12\6\0\10\12"+
    "\1\146\6\12\1\146\20\12\2\0\3\12\20\0\1\12"+
    "\6\0\3\12\6\0\14\12\1\147\23\12\2\0\3\12"+
    "\20\0\1\12\6\0\3\12\6\0\20\12\1\150\16\12"+
    "\1\151\2\0\3\12\20\0\1\12\6\0\3\12\6\0"+
    "\25\12\1\152\7\12\1\153\2\12\2\0\3\12\20\0"+
    "\1\12\6\0\3\12\6\0\12\12\1\154\25\12\2\0"+
    "\3\12\20\0\1\12\6\0\3\12\6\0\33\12\1\155"+
    "\4\12\2\0\3\12\20\0\1\12\6\0\3\12\6\0"+
    "\20\12\1\156\17\12\2\0\3\12\20\0\1\12\6\0"+
    "\3\12\6\0\12\12\1\157\25\12\2\0\3\12\20\0"+
    "\1\12\6\0\3\12\6\0\12\12\1\160\25\12\2\0"+
    "\3\12\20\0\1\12\6\0\3\12\6\0\30\12\1\161"+
    "\7\12\2\0\3\12\20\0\1\12\6\0\3\12\6\0"+
    "\16\12\1\162\21\12\2\0\3\12\20\0\1\12\6\0"+
    "\3\12\6\0\14\12\1\163\23\12\2\0\3\12\20\0"+
    "\1\12\6\0\3\12\6\0\23\12\1\164\14\12\2\0"+
    "\3\12\20\0\1\12\6\0\3\12\6\0\24\12\1\165"+
    "\13\12\2\0\3\12\20\0\1\12\6\0\3\12\6\0"+
    "\14\12\1\166\23\12\2\0\3\12\20\0\1\12\6\0"+
    "\3\12\6\0\40\12\2\0\1\12\1\167\1\12\20\0"+
    "\1\12\6\0\3\12\6\0\13\12\1\170\24\12\2\0"+
    "\3\12\20\0\1\12\6\0\3\12\6\0\31\12\1\171"+
    "\6\12\2\0\3\12\20\0\1\12\6\0\3\12\6\0"+
    "\15\12\1\172\22\12\2\0\3\12\20\0\1\12\6\0"+
    "\3\12\6\0\14\12\1\173\23\12\2\0\3\12\20\0"+
    "\1\12\6\0\3\12\6\0\17\12\1\174\16\12\1\175"+
    "\1\12\2\0\3\12\20\0\1\12\6\0\1\135\10\0"+
    "\1\135\64\0\1\135\6\0\1\176\10\0\1\176\64\0"+
    "\1\176\2\0\14\143\1\177\70\143\13\0\1\7\1\144"+
    "\74\0\3\12\6\0\4\12\1\200\26\12\1\200\4\12"+
    "\2\0\3\12\20\0\1\12\6\0\3\12\6\0\11\12"+
    "\1\201\1\12\1\201\24\12\2\0\3\12\20\0\1\12"+
    "\6\0\3\12\6\0\13\12\1\202\24\12\2\0\3\12"+
    "\20\0\1\12\6\0\3\12\6\0\12\12\1\203\25\12"+
    "\2\0\3\12\20\0\1\12\6\0\3\12\6\0\23\12"+
    "\1\204\14\12\2\0\3\12\20\0\1\12\6\0\3\12"+
    "\6\0\20\12\1\205\17\12\2\0\3\12\20\0\1\12"+
    "\6\0\3\12\6\0\13\12\1\206\24\12\2\0\3\12"+
    "\20\0\1\12\6\0\3\12\6\0\16\12\1\207\21\12"+
    "\2\0\3\12\20\0\1\12\6\0\3\12\6\0\13\12"+
    "\1\210\24\12\2\0\3\12\20\0\1\12\6\0\3\12"+
    "\6\0\12\12\1\211\25\12\2\0\3\12\20\0\1\12"+
    "\6\0\3\12\6\0\15\12\1\212\22\12\2\0\3\12"+
    "\20\0\1\12\6\0\3\12\6\0\16\12\1\213\21\12"+
    "\2\0\3\12\20\0\1\12\6\0\3\12\6\0\32\12"+
    "\1\214\5\12\2\0\3\12\20\0\1\12\6\0\3\12"+
    "\6\0\14\12\1\215\23\12\2\0\3\12\20\0\1\12"+
    "\6\0\3\12\6\0\12\12\1\216\25\12\2\0\3\12"+
    "\20\0\1\12\6\0\3\12\6\0\25\12\1\217\12\12"+
    "\2\0\3\12\20\0\1\12\6\0\3\12\6\0\12\12"+
    "\1\220\25\12\2\0\3\12\20\0\1\12\6\0\3\12"+
    "\6\0\40\12\2\0\2\12\1\221\20\0\1\12\6\0"+
    "\3\12\6\0\23\12\1\222\14\12\2\0\3\12\20\0"+
    "\1\12\6\0\3\12\6\0\20\12\1\223\17\12\2\0"+
    "\3\12\20\0\1\12\2\0\13\143\1\7\1\177\70\143"+
    "\4\0\3\12\6\0\5\12\1\224\31\12\1\224\2\0"+
    "\3\12\20\0\1\12\6\0\3\12\6\0\2\12\1\225"+
    "\20\12\1\225\14\12\2\0\3\12\20\0\1\12\6\0"+
    "\3\12\6\0\15\12\1\226\22\12\2\0\3\12\20\0"+
    "\1\12\6\0\3\12\6\0\16\12\1\227\21\12\2\0"+
    "\3\12\20\0\1\12\6\0\3\12\6\0\40\12\1\230"+
    "\1\0\3\12\20\0\1\12\6\0\3\12\6\0\16\12"+
    "\1\231\21\12\2\0\3\12\20\0\1\12\6\0\3\12"+
    "\6\0\20\12\1\232\17\12\2\0\3\12\20\0\1\12"+
    "\6\0\3\12\6\0\13\12\1\233\24\12\2\0\3\12"+
    "\20\0\1\12\6\0\3\12\6\0\12\12\1\234\25\12"+
    "\2\0\3\12\20\0\1\12\6\0\3\12\6\0\16\12"+
    "\1\235\21\12\2\0\3\12\20\0\1\12\6\0\3\12"+
    "\6\0\13\12\1\236\24\12\2\0\3\12\20\0\1\12"+
    "\6\0\3\12\6\0\16\12\1\237\21\12\2\0\3\12"+
    "\20\0\1\12\6\0\3\12\6\0\13\12\1\240\24\12"+
    "\2\0\3\12\20\0\1\12\6\0\3\12\6\0\21\12"+
    "\1\241\16\12\2\0\3\12\20\0\1\12\3\0\3\242"+
    "\3\12\6\0\40\12\2\0\3\12\20\0\1\12\1\0"+
    "\1\242\1\0\3\243\3\12\6\0\40\12\2\0\3\12"+
    "\20\0\1\12\1\0\1\243\4\0\3\12\6\0\16\12"+
    "\1\244\21\12\2\0\3\12\20\0\1\12\6\0\3\12"+
    "\6\0\12\12\1\245\25\12\2\0\3\12\20\0\1\12"+
    "\60\0\1\246\32\0\3\12\6\0\21\12\1\247\16\12"+
    "\2\0\3\12\20\0\1\12\6\0\3\12\6\0\30\12"+
    "\1\250\7\12\2\0\3\12\20\0\1\12\6\0\3\12"+
    "\6\0\32\12\1\251\5\12\2\0\3\12\20\0\1\12"+
    "\3\0\3\242\17\0\1\252\33\0\1\252\24\0\1\242"+
    "\1\0\3\243\17\0\1\253\33\0\1\253\24\0\1\243"+
    "\4\0\3\12\6\0\15\12\1\254\22\12\2\0\3\12"+
    "\20\0\1\12\6\0\3\12\6\0\16\12\1\255\21\12"+
    "\2\0\3\12\20\0\1\12\26\0\1\256\26\0\1\256"+
    "\55\0\1\257\26\0\1\257\35\0\3\12\6\0\16\12"+
    "\1\260\21\12\2\0\3\12\20\0\1\12\6\0\3\12"+
    "\6\0\13\12\1\261\24\12\2\0\3\12\20\0\1\12"+
    "\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7797];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\4\0\1\11\1\1\2\11\2\1\3\11\1\1\1\11"+
    "\16\1\1\11\1\1\12\11\3\1\1\11\4\1\2\11"+
    "\4\1\1\0\31\1\7\11\1\1\3\11\1\1\5\11"+
    "\2\0\31\1\1\11\1\0\30\1\1\0\11\1\2\0"+
    "\2\1\1\11\3\1\2\0\2\1\2\11\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[177];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    StringBuilder string = new StringBuilder();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public ExpressionLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 214) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(ExpressionSymbols.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new Error("Illegal character <"+yytext()+">");
            }
          case 72: break;
          case 2: 
            { /* ignore */
            }
          case 73: break;
          case 3: 
            { return symbol(NUMBER, Integer.valueOf(yytext()));
            }
          case 74: break;
          case 4: 
            { return symbol(IDENTIFIER, yytext());
            }
          case 75: break;
          case 5: 
            { yybegin(STRING_SINGLE_QUOTE); string.setLength(0);
            }
          case 76: break;
          case 6: 
            { yybegin(STRING_DOUBLE_QUOTE); string.setLength(0);
            }
          case 77: break;
          case 7: 
            { yybegin(STRING_GRAVE_ACCENT); string.setLength(0);
            }
          case 78: break;
          case 8: 
            { return symbol(DIV);
            }
          case 79: break;
          case 9: 
            { return symbol(MULT);
            }
          case 80: break;
          case 10: 
            { return symbol(COLON);
            }
          case 81: break;
          case 11: 
            { return symbol(EQ);
            }
          case 82: break;
          case 12: 
            { return symbol(LPAREN);
            }
          case 83: break;
          case 13: 
            { return symbol(RPAREN);
            }
          case 84: break;
          case 14: 
            { return symbol(LBRACK);
            }
          case 85: break;
          case 15: 
            { return symbol(RBRACK);
            }
          case 86: break;
          case 16: 
            { return symbol(COMMA);
            }
          case 87: break;
          case 17: 
            { return symbol(DOT);
            }
          case 88: break;
          case 18: 
            { return symbol(LCURLY);
            }
          case 89: break;
          case 19: 
            { return symbol(RCURLY);
            }
          case 90: break;
          case 20: 
            { return symbol(PLUS);
            }
          case 91: break;
          case 21: 
            { return symbol(MINUS);
            }
          case 92: break;
          case 22: 
            { return symbol(GT);
            }
          case 93: break;
          case 23: 
            { return symbol(LT);
            }
          case 94: break;
          case 24: 
            { return symbol(NOT);
            }
          case 95: break;
          case 25: 
            { return symbol(QUESTION);
            }
          case 96: break;
          case 26: 
            { string.append( yytext() );
            }
          case 97: break;
          case 27: 
            { throw new RuntimeException("Unterminated string at end of line");
            }
          case 98: break;
          case 28: 
            { yybegin(YYINITIAL); return symbol(STRING, string.toString());
            }
          case 99: break;
          case 29: 
            { return symbol(IS);
            }
          case 100: break;
          case 30: 
            { return symbol(IN);
            }
          case 101: break;
          case 31: 
            { return symbol(OR);
            }
          case 102: break;
          case 32: 
            { return symbol(AS);
            }
          case 103: break;
          case 33: 
            { return symbol(EQEQ);
            }
          case 104: break;
          case 34: 
            { return symbol(GTEQ);
            }
          case 105: break;
          case 35: 
            { return symbol(LTEQ);
            }
          case 106: break;
          case 36: 
            { return symbol(NOTEQ);
            }
          case 107: break;
          case 37: 
            { return symbol(AND);
            }
          case 108: break;
          case 38: 
            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\"");
            }
          case 109: break;
          case 39: 
            { char val = (char) Integer.parseInt(yytext().substring(1),8);
                        				   string.append( val );
            }
          case 110: break;
          case 40: 
            { string.append( '\'' );
            }
          case 111: break;
          case 41: 
            { string.append( '\"' );
            }
          case 112: break;
          case 42: 
            { string.append( '\\' );
            }
          case 113: break;
          case 43: 
            { string.append( '\t' );
            }
          case 114: break;
          case 44: 
            { string.append( '\n' );
            }
          case 115: break;
          case 45: 
            { string.append( '\f' );
            }
          case 116: break;
          case 46: 
            { string.append( '\r' );
            }
          case 117: break;
          case 47: 
            { string.append( '\b' );
            }
          case 118: break;
          case 48: 
            { return symbol(ASC);
            }
          case 119: break;
          case 49: 
            { return symbol(ALL);
            }
          case 120: break;
          case 50: 
            { return symbol(ANY);
            }
          case 121: break;
          case 51: 
            { return symbol(LIKE);
            }
          case 122: break;
          case 52: 
            { return symbol(LAST);
            }
          case 123: break;
          case 53: 
            { return symbol(BOOLEAN, Boolean.TRUE);
            }
          case 124: break;
          case 54: 
            { return symbol(THIS);
            }
          case 125: break;
          case 55: 
            { return symbol(DESC);
            }
          case 126: break;
          case 56: 
            { return symbol(NULL);
            }
          case 127: break;
          case 57: 
            { return symbol(FROM);
            }
          case 128: break;
          case 58: 
            { return symbol(LIMIT);
            }
          case 129: break;
          case 59: 
            { return symbol(IMAGE);
            }
          case 130: break;
          case 60: 
            { return symbol(NULLS);
            }
          case 131: break;
          case 61: 
            { return symbol(FIRST);
            }
          case 132: break;
          case 62: 
            { return symbol(BOOLEAN, Boolean.FALSE);
            }
          case 133: break;
          case 63: 
            { return symbol(WHERE);
            }
          case 134: break;
          case 64: 
            { return symbol(SELECT);
            }
          case 135: break;
          case 65: 
            { return symbol(EXISTS);
            }
          case 136: break;
          case 66: 
            { return symbol(EXPR_START);
            }
          case 137: break;
          case 67: 
            { return symbol(HAVING);
            }
          case 138: break;
          case 68: 
            { return symbol(GROUP_BY);
            }
          case 139: break;
          case 69: 
            { return symbol(ORDER_BY);
            }
          case 140: break;
          case 70: 
            { return symbol(DISTINCT);
            }
          case 141: break;
          case 71: 
            { return symbol(OBJ_STATE);
            }
          case 142: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
