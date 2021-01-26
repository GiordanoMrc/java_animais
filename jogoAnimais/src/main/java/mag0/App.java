package mag0;


import javax.swing.JOptionPane;

import mag0.Domain.NodeBT;
import mag0.Interface.Animal;

public class App implements Animal<NodeBT>
{
    public static int index = 1;
    public static NodeBT rootNode;

    @Override
    public NodeBT getTree() {
        return rootNode;
        
    }
    @Override
    public void setTree(NodeBT tree) {
        rootNode = tree;
    }

    @Override
    public void insertAnimal(NodeBT nodeBT) {
        String animal = JOptionPane.showInputDialog(null, "Qual animal você imaginou?");
        String animalDoing = JOptionPane.showInputDialog(null, "Um(a) " + animal + "______ mas um(a) " + nodeBT.value + " não.");
        String aux = nodeBT.value;
        nodeBT.value = animalDoing;
        nodeBT.rightNode = new NodeBT(++index, animal);
        nodeBT.leftNode = new NodeBT(++index, aux);
    }

    @Override
    public void question(NodeBT nodeBT) {
        int ask = JOptionPane.showConfirmDialog(null, "O animal que você imaginou: " + nodeBT.value + "?" , "Confirme",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(ask == 0){
            if(nodeBT.rightNode == null){
                JOptionPane.showMessageDialog(null, "Acertei de novo!");
            } else {
                question(nodeBT.rightNode);
            }
        } else {
            if (nodeBT.leftNode == null) {
                insertAnimal(nodeBT);
            } else {
                question(nodeBT.leftNode);
            }
        }
    }
    public static void main( String[] args )
    {
        App main = new App();
        do {
            JOptionPane.showMessageDialog(null, "Imagine um Animal! :0)");
            if (main.getTree()== null) {
                main.setTree(new NodeBT(index, "vive na agua?"));
                main.getTree().leftNode = new NodeBT(++index, "Cachorro");
                main.getTree().rightNode = new NodeBT(++index, "Peixe Palhaço");            
            }
            int answer = JOptionPane.showConfirmDialog(null, "O animal que você pensou " + main.getTree().value,
                    "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (answer == JOptionPane.CLOSED_OPTION || answer == JOptionPane.CANCEL_OPTION){
                break;
            } else if (answer == 0) {
                main.question(main.getTree().rightNode);
            } else {
                main.question(main.getTree().leftNode);
            }
        } while (true);
    }
}
