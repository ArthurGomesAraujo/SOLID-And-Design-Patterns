package before.refactor;

public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    @Override
    public void setWidth(int width) {
        setSide(width);
    }

    @Override
    public void setHeight(int height) {
        setSide(height);
    }

    //granting a square remains a square even with different values
    public void setSide(int side) {
        super.setWidth(side);
        super.setHeight(side);
    }
}
