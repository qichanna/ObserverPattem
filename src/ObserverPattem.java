import java.util.Observable;
import java.util.Observer;

public class ObserverPattem {

    public static void main(String[] args) {
        HanFeiZi hf = new HanFeiZi();
        LiSi ls = new LiSi();
        hf.addObserver(ls);
        hf.haveBreakfast();
        hf.haveFun();
    }

    public interface IHanFeiZi {
        public void haveBreakfast();
        public void haveFun();
    }

    public static class HanFeiZi extends Observable implements IHanFeiZi{


        @Override
        public void haveBreakfast() {
            System.out.println("韩非：开始吃饭了.....");

            super.setChanged();
            super.notifyObservers("韩非在吃饭");
        }

        @Override
        public void haveFun() {
            System.out.println("韩非：开始娱乐了.....");

            super.setChanged();
            super.notifyObservers("韩非在娱乐");
        }
    }


    public static class LiSi implements Observer {

        @Override
        public void update(Observable o, Object obj) {
            System.out.println("李斯：观察到韩非开始吃饭.....");
            report(obj.toString());
            System.out.println("李斯：汇报完毕.....");
        }

        private void report(String str){
            System.out.println("print: " + str);
        }
    }

}
