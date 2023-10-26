public class NBody {
    private static final String background="images/starfield.jpg";
    public static double readRadius(String name){
        In in=new In(name);
        int number=in.readInt();
        double radius=in.readDouble();
        return radius;

    }
    public static Planet[] readPlanets(String name){
        In in=new In(name);
        int number=in.readInt();
        double radius=in.readDouble();
        Planet ans[]=new Planet[number];
        for(int i=0;i<number;++i){
            ans[i]=new Planet(
            in.readDouble(),
            in.readDouble(),
            in.readDouble(),
            in.readDouble(),
            in.readDouble(),
            in.readString());
        }
        return ans;
    }
    public static void main(String[] args) {
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        Planet []ps=readPlanets(filename);
        double radius=readRadius(filename);
        StdDraw.setXscale(-radius,radius);
        StdDraw.setYscale(-radius,radius);
        StdDraw.enableDoubleBuffering();
        double t=0;
        int num=ps.length;
        while(t<=T){
            double[] xForces=new double[num];
            double[] yForces=new double[num];
            for(int i=0;i<num;i++){
                xForces[i]=ps[i].calcNetForceExertedByX(ps);
                yForces[i]=ps[i].calcNetForceExertedByY(ps);
            }
            for(int i=0;i<num;i++){
                ps[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,background);
            for(Planet p:ps){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t+=dt;
        }
        StdOut.printf("%d\n", ps.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < ps.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    ps[i].xxPos, ps[i].yyPos, ps[i].xxVel,
                    ps[i].yyVel, ps[i].mass, ps[i].imgFileName);
        }


    }
}
