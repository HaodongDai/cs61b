public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	/* public static final G = 6.67e-11 (final indicates that 
	the value of this variable won't change */ 
	//* First constructor  */
	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

    //* Second Constructor */
    public Planet(Planet b) {
    	this.xxPos = b.xxPos;
    	this.yyPos = b.yyPos;
    	this.xxVel = b.xxVel;
    	this.yyVel = b.yyVel;
    	this.mass = b.mass;
    	this.imgFileName = b.imgFileName;
    }


    //* calculate distance */
    public double calcDistance(Planet b) {
    	double xdif = this.xxPos - b.xxPos;
    	double ydif = this.yyPos - b.yyPos;
    	return Math.sqrt(xdif*xdif + ydif*ydif);
    }

    public double calcForceExertedBy(Planet b) {
    	double G = 6.67e-11;
    	double dist = this.calcDistance(b);
    	return (G*this.mass*b.mass)/(dist*dist);
    }

    public double calcForceExertedByX(Planet b) {
    	double F = this.calcForceExertedBy(b);
    	return F * (b.xxPos - this.xxPos) / this.calcDistance(b);
    }

    public double calcForceExertedByY(Planet b) {
    	double F = this.calcForceExertedBy(b);
    	return F * (b.yyPos - this.yyPos) / this.calcDistance(b);
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
    	double netforce = 0;
    	int i = 0;
    	while (i < allPlanets.length) {
    		if (!this.equals(allPlanets[i])) {
    			netforce += this.calcForceExertedByX(allPlanets[i]);
    		}
    		i += 1;
    	}
    	return netforce;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
    	double netforce = 0;
    	int i = 0;
    	while (i < allPlanets.length) {
    		if (!this.equals(allPlanets[i])) {
    			netforce += this.calcForceExertedByY(allPlanets[i]);
    		}
    		i += 1;
    	}
    	return netforce;
    }

    public void update(double dt, double fX, double fY) {
    	double aX = fX/ this.mass;
    	double aY = fY/ this.mass;
    	this.xxVel += aX * dt;
    	this.yyVel += aY * dt;
    	this.xxPos += this.xxVel * dt;
    	this.yyPos += this.yyVel * dt;
    }

    public void draw() {
    	String fullpath = "./images/" + this.imgFileName;
    	StdDraw.picture(this.xxPos, this.yyPos, fullpath);

    }



}