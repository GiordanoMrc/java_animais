package mag0.Domain;

public class NodeBT {
    public int element;
    public String value;
    public NodeBT leftNode;
    public NodeBT rightNode;

    public NodeBT(int element, String value) {
        System.out.println(element + " - " + value);
        this.element = element;
        this.value = value;

    }
}
