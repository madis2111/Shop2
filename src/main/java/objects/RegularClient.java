package objects;

import interfaces.Rater;

public class RegularClient extends User implements Rater {


    public RegularClient(int money, Store store) {
        super(money, store);
    }

//    public void rate(objects.Product product, int rating) {
//            getStore().     // todo
//    }


}
