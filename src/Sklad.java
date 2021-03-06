
import java.util.ArrayList;
import java.util.List;


class Element<Tip> {

    public Tip vrednost;
    public Element<Tip> vezava;

    public Element(Tip e) {
        this.vrednost = e;
    }
}

public class Sklad<Tip> implements Seznam<Tip> {

    private Element<Tip> vrh;

    public Sklad() {
    }

    public void push(Tip e) {
        Element<Tip> novVrh = new Element<>(e);
        novVrh.vezava = vrh;
        vrh = novVrh;
    }

    public Tip pop() {
        if (vrh == null) {
            throw new java.util.NoSuchElementException();
        }
        Tip e = vrh.vrednost;
        vrh = vrh.vezava;
        return e;
    }

    @Override
    public boolean isEmpty() {
        return (vrh == null);
    }

    public Tip top() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return vrh.vrednost;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }

        int stElementov = 0;
        Element<Tip> tmp = vrh;
        while (tmp != null) {
            stElementov++;
            tmp = tmp.vezava;
        }
        return stElementov;
    }

    public boolean isTop(Tip e) {
        if (vrh == null) {
            throw new java.util.NoSuchElementException();
        }
        return vrh.vrednost.equals(e);
    }

    public int search(Tip e) {
        Element<Tip> tmp = vrh;
        int i = 0;
        while (null != tmp) {
            if (tmp.vrednost.equals(e)) {
                return i;
            }
            i++;
            tmp = tmp.vezava;
        }
        return -1;
    }

    @Override
    public void add(Tip e) {
        this.push(e);
    }

    @Override
    public Tip removeFirst() {
        return this.pop();
    }

    @Override
    public Tip getFirst() {
        return top();
    }

    @Override
    public int depth() {
        return this.size();
    }

    @Override
    public Tip remove(Tip e) {
        if(isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        Sklad<Tip> tmp = new Sklad<>();
        Tip rez = null;
        while (!this.isEmpty()) {
            Tip p = this.pop();
            if (p.equals(e)) {
                rez = p;
                break;
            }
            tmp.push(p);
        }

        while (!tmp.isEmpty()) {
            this.push(tmp.pop());
        }

        return rez;
    }

    @Override
    public boolean exists(Tip e) {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Element<Tip> tmp = vrh;
        while(tmp != null){
            
            if(tmp.vrednost.equals(e)){                                                
                return true;
            }
            tmp=tmp.vezava;
        }
        return false;
    }

    @Override
    public List<Tip> asList() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        List<Tip> list = new ArrayList<Tip>();
        Element<Tip> tmp = vrh;
        while(tmp != null){
            list.add(tmp.vrednost);
            tmp = tmp.vezava;
        }
        return list;
    }

    




}
