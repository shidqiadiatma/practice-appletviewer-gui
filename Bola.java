import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Shidqi Adiatma
 */
public class Bola extends Applet implements Runnable, ActionListener {
    Button h, v;

    int x, arahX;
    int y, arahY;
    int pilihan = 0;
    
    public void init(){

        h = new Button("Horizontal"); // yang ditambahkan
        h.setBounds(300, 40, 80, 30); // yang ditambahkan
        h.addActionListener(this); // yang ditambahkan

        v = new Button("Vertikal"); // yang ditambahkan
        v.setBounds(300, 80, 80, 30); // yang ditambahkan
        v.addActionListener(this); // yang ditambahkan

        add(h); // yang ditambahkan
        add(v);

        x = 50;
        y = 50;

        arahX = 2;
        arahY = 2;
        
        Thread t = new Thread(this);
        t.start();
        
    }
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.drawRect(5,5,240,240);
        g.setColor(Color.red);
        g.fillOval(x, y , 20, 20);
    }
    public void run(){
        while (true){
            try{
                cekBola(pilihan);
                Thread.sleep(5);
                repaint();
            } catch (Exception e){}
        }
    }
    public void cekBola(int arah){
        if (arah == 1){
            if(y > 225|| y < 5){
                arahY = -arahY;
            }
            x = 50;
            y = y + arahY;
        }else if (arah == 0){
            if (x > 225 || x < 5){
                arahX =-arahX;
            }
            y = 50;
            x = x + arahX;
        }else {
            if (x > 225 || y < 5) {
                arahX = -arahX;
                arahY =-arahY;
            }
            x = x + arahX;
            y = y + arahY;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String y = e.getActionCommand();
        switch (y) {
            case "Horizontal":
                pilihan = 0;
                break;

            case "Vertikal":
                pilihan = 1;
                break;
        }
    }

}