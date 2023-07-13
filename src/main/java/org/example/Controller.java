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
            System.out.println("Введены не все данные");
        } catch (RuntimeException x) {
            throw new RuntimeException(x);
        }
        chek(parser);

    }

    public void chek(ParcerData parser) throws IOException {
        if (parser.getDate() == null) {
            System.out.println("Пожалуйста повторите ввод");
        } else if (parser.getPhone() == null) {
            System.out.println("В номере телефона присутсвует недопустимое значение");
            System.out.println("Пожалуйста повторите ввод");
        } else {
            WriterData wd = new WriterData(parser);
            wd.write();
        };
    }

}