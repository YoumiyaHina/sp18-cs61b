public class Planet {
    public double xxPos;
    public  double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    static  final double G=6.67e-11;
    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }
    public  Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName =p.imgFileName;
    }
    public double calcDistance(Planet p){
        double r2=(p.xxPos-this.xxPos)*(p.xxPos-this.xxPos)+(p.yyPos-this.yyPos)*(p.yyPos-this.yyPos);
        return Math.sqrt(r2);
    }
    public double calcForceExertedBy(Planet p){
        return G*this.mass*p.mass/(this.calcDistance(p)*this.calcDistance(p));
    }
    public double calcForceExertedByX(Planet p){
        return calcForceExertedBy(p)*(p.xxPos-this.xxPos)/calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        return calcForceExertedBy(p)*(p.yyPos-this.yyPos)/calcDistance(p);
    }
    public double calcNetForceExertedByX(Planet[]ps){
        double netX=0;
        for(Planet p:ps){
            if(this.equals(p)) continue;
            netX+=calcForceExertedByX(p);
        }
        return netX;
    }
    public double calcNetForceExertedByY(Planet[]ps){
        double netY=0;
        for(Planet p:ps){
            if(this.equals(p)) continue;
            netY+=calcForceExertedByY(p);
        }
        return netY;
    }
    public void update(double dt,double fX,double  fY){
        xxVel=xxVel+fX/mass*dt;
        yyVel=yyVel+fY/mass*dt;
        xxPos=xxPos+xxVel*dt;
        yyPos=yyPos+yyVel*dt;
    }
    public  void draw(){
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }
}
