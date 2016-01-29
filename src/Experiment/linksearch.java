package Experiment;


class LinkList {
    public int val;
    public LinkList next;
    public LinkList(int x) { val = x; }
}

public class linksearch {
    static LinkList SearchCommon(LinkList h1,LinkList h2){
        LinkList h1temp=h1;
        LinkList h2temp=h2;
        int h1length=0;
        int h2length=0;
        while (h1temp!=null){
            h1length++;
            h1temp=h1temp.next;
        }
        while (h2temp!=null){
            h2length++;
            h2temp=h2temp.next;
        }

        for (int i=0;i<Math.abs(h1length-h2length);i++){
            if (h1length>h2length){
                h1=h1.next;
            }
            else{
                h2=h2.next;
            }
        }

        while(h1!=null && h2!=null){
            if (h1.equals(h2)){
                return h1;
            }
            else{
                h1=h1.next;
                h2=h2.next;
            }
        }
        return null;
    }

    public static void main(String[] args){
        LinkList headA=new LinkList(3);
        LinkList headB=new LinkList(23);
        LinkList A2=new LinkList(4);
        LinkList A3=new LinkList(5);
        LinkList B2=new LinkList(24);
        LinkList common1=new LinkList(48);
        LinkList common2=new LinkList(49);
        headA.next=A2;A2.next=A3;A3.next=common1;common1.next=common2;
        headB.next=B2; B2.next=common1;
        LinkList res=SearchCommon(headA,headB);
        if (res==null){
            System.out.println("there is no common value");
        }
        else{
            System.out.println("the value of the first common value is " + res.val);
        }

    }
}
