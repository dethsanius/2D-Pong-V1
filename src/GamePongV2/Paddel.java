package GamePongV2;

import EnginPongV2.AbstractEntity;

import java.awt.*;


public abstract class Paddel extends AbstractEntity {
    protected int WITH = ReferencePongV2.paddelWith, HIGHT = ReferencePongV2.paddelHight;

    public Paddel(int x, int y) {
        super(x, y);
    }

    public void smalPaddle(){
        HIGHT = HIGHT / 2;
    }

    public void largerPabble(){
        HIGHT = HIGHT * 2;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) getX(), (int) getY(), WITH, HIGHT);
    }

    public void checkColition(Ball ball) {
        if (ball.getBounds().intersects(getBounds())){
            ball.negateX();
        }
        if (getY() <= 0)
            setY(0);
        else if (getY() + HIGHT >= ReferencePongV2.winY)
            setY(ReferencePongV2.winY - HIGHT);
    }

    public double getWith(){
        return WITH;
    }

    public double getHeight(){
        return HIGHT;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect((int) getX(), (int) getY(), WITH, HIGHT);
    }
}
