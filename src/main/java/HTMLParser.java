/**
 * Created by Pronious on 28/06/16.
 */
import  org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HTMLParser{


    String URL;
    List<String> tagList;

    public HTMLParser(String URL){
        this.URL=URL;
        tagList= new ArrayList<String>();
    }
    public void parse() throws IOException {
        Document doc = Jsoup.connect(this.URL).get();
        Elements trs= doc.select("tr");
        String directive= this.URL.substring(73,91);
        int tdCounter;
        int trCounter=0;
        String url="";
        String size="";
        for (Element tr : trs) {
            ++trCounter;
            if(trCounter==3 || trCounter==303 || trCounter==304 || trCounter==305 || trCounter==306){
            }
            else{
                Elements tds= tr.getElementsByTag("td");
                tdCounter=0;
                boolean Burl=false;
                boolean Bsize = false;
                for(Element td : tds){
                    ++tdCounter;

                    if(tdCounter==2 || tdCounter==4){
                        if(tdCounter==2){
                            url=td.text();
                            Burl=true;
                        }
                        else{
                            size=td.text();
                            Bsize= true;
                        }
                        if(Bsize&& Burl){
                            tagGenerator(this.tagList, directive, url, size);
                            Burl=false;
                            Bsize = false;
                        }
                    }
                    else{

                    }
                }
            }
        }
    }
    public void tagGenerator(List<String> list,String directive, String url, String size){
        String newTag= new String("<SegmentURL media=\""+directive+url+"\""+" size="+"\""+size+"\"/>");
        list.add(newTag);
    }
    public void print() {
        List<String> print= this.tagList;
        for(String str : print){
            System.out.println(str.toString());
        }
    }
}



