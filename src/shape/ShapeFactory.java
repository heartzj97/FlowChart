package shape;

public class ShapeFactory {
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("ARROW")){
            return new MyArrow();
        } else if(shapeType.equalsIgnoreCase("DIAMOND")){
            return new MyDiamond();
        } else if(shapeType.equalsIgnoreCase("OVAL")){
            return new MyOval();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new MySquare();
        } else if(shapeType.equalsIgnoreCase("TEXT")){
            return new MyText();
        }
        return null;
    }
}
