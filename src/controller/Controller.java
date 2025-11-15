package controller;

import java.util.ArrayList;
import model.MainObserver;

public class Controller<T extends MainObserver> {

    ArrayList<T> arrayList = new ArrayList<>();

    public void add(T t) {
        arrayList.add(t);
    }

    public void updateUnites(String s) {
        for (T t : arrayList) {
            t.updateMessage(s);
        }
    }

    public void sendAreaClearMessage(boolean clear) {
        for (T t : arrayList) {
            t.clearArea(clear);
        }
    }
    
    public void enableButtons(int value){
      for(T t : arrayList){
       t.buttonEnable(value);
      }
    }
}
