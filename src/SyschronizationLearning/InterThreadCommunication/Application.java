package SyschronizationLearning.InterThreadCommunication;

public class Application {

    public static void main(String[] args) {

        ProducerAndConsumer pc = new ProducerAndConsumer(5);

        Thread t1 = new Thread(() ->{
            try {
                for(int i=1;i<10;i++) {
                    pc.produce(i);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        });


        Thread t2 = new Thread(() ->{
            try {
                for(int i=1;i<10;i++) {
                     pc.consume();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        });

        t1.start();
        t2.start();
    }
}
