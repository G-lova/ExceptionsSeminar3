package org.example;
import org.example.WrongFormat;
import java.util.List;
public class UserData {

    public List<String> data;

    public UserData(String data) throws WrongFormat {
        List<String> dataList = List.of(data.split(" "));
        if (dataList.size() < 6) throw new WrongFormat();
        else {
            this.data = dataList;
        }
    }
}