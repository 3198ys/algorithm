package jichu;

import java.util.LinkedList;

public class xunhuanduilie {

    private Integer MAXSIZE=6;
    private Object[] arr;
    private Integer front;
    private Integer rear;
    private Integer sum=0;
    public void initQueue(){
        arr=new Object[MAXSIZE];
        front=rear=0;
    }

    public boolean isEmpty(){

        if(front==rear){
            return true;
        }else{
            return false;
        }
    }

    public Integer queueLength(){

        return (rear-front+MAXSIZE)%MAXSIZE;
    }
    public void add(Object e){
        if((rear+1)%MAXSIZE==front){
            return;
        }
        arr[rear]=e;
        rear=(rear+1)%MAXSIZE;
    }
    public void pop(){
        if(rear==front){
           return ;
        }
        Object e=arr[front];
        front=(front+1)%MAXSIZE;
    }
}
