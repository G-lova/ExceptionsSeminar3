package org.example;

import org.example.ParcerData;
import org.example.ScannerData;
import org.example.UserData;
import org.example.WriterData;
import org.example.WrongFormat;

import java.io.IOException;


public class Controller {
    public void Start() throws IOException {
        ScannerData data = new ScannerData();
        ParcerData parser = new ParcerData();
        UserData userData;
        try {
            userData = new UserData(data.getData());
            parser.parse(userData.data);

        } catch (WrongFormat e) {
            System.out.println("??????? ?? ??? ??????");
        } catch (RuntimeException x) {
            throw new RuntimeException(x);
        }
        chek(parser);

    }

    public void chek(ParcerData parser) throws IOException {
        if (parser.getDate() == null) {
            System.out.println("?????????? ????????? ????");
        } else if (parser.getPhone() == null) {
            System.out.println("? ?????? ???????? ??????????? ???????????? ????????");
            System.out.println("?????????? ????????? ????");
        } else {
            WriterData wd = new WriterData(parser);
            wd.write();
        };
    }

}