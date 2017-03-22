
import java.io.IOException;


/**
 * Created by Pronious on 28/06/16.
 */
public class test {
    public static void main(String[] args) throws IOException {
        HTMLParser parser= new HTMLParser("http://www-itec.uni-klu.ac.at/ftp/datasets/mmsys12/BigBuckBunny/bunny_2s/bunny_2s_8000kbit/");
        parser.parse();
        parser.print();

    }
}
