package improvement;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class mavenDemo {

    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        demo('间');
    }
    public static void demo(char s) throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat demo = new HanyuPinyinOutputFormat();

        demo.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        demo.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        String str[] = PinyinHelper.toHanyuPinyinStringArray(s,demo);
        System.out.println(str);
    }
}
