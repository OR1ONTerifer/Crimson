package net.crimson.java.math;

/**
 * This class defines a pointer in 2D space called a vector, using 
 * exclusively floats for its x and y components. This can be used 
 * to store positions, directions, rotations, and more. Subclass of 
 * Vector. Consider using UFT-8 Text encoding to see special characters 
 * in the Javadoc comments.
 * 
 * <p> Anything in <i> italic</i> references a parameter of the function.
 * <i> 'the current vector'</i> references the current Vector2f object.
 * 
 * <p> Static methods here are for calculations with a connection to
 * vectors, but do not strictly have to be based on vectors.
 * 
 * <p> Static properties are for utility purposes only, and do not
 * serve a purpose in instances of this class.
 * 
 * @author OR1ON
 * 
 * @since 1.0
 */
public final class Vector2f extends Vector{
	/** 
	 * X component of the vector.
	 */
	public float x;
	
	/** 
	 * Y component of the vector.
	 */
	public float y;
	
	/**
	 * The number of decimal places to round off to when doing float calculations.
	 */
	public int floatPrecisionFactor = 10;
	
	/** 
	 * Quicker way for writing a Vector2f with x = 0 and y = 0.
	 */
	public static final Vector2f zero = new Vector2f(0, 0);
	
	/** 
	 * Quicker way for writing a Vector2f with x = 1 and y = 1.
	 */
	public static final Vector2f one = new Vector2f(1, 1);
	
	/** 
	 * Quicker way for writing a Vector2f with x = -1 and y = -1.
	 */
	public static final Vector2f negativeOne = new Vector2f(-1, -1);
	
	/** 
	 * Quicker way for writing a Vector2f pointing up.
	 */
	public static final Vector2f up = new Vector2f(0, 1);
	
	/** 
	 * Quicker way for writing a Vector2f pointing down.
	 */
	public static final Vector2f down = new Vector2f(0, -1);
	
	/** 
	 * Quicker way for writing a Vector2f pointing left.
	 */
	public static final Vector2f left = new Vector2f(-1, 0);
	
	/** 
	 * Quicker way for writing a Vector2f pointing right.
	 */
	public static final Vector2f right = new Vector2f(1, 0);
	
	/**
	 * Constructor for the Vector2f, setting the x and y components to
	 * the provided parameters.
	 * 
	 * @param x
	 * 		  x component to store in the object.
	 * @param y
	 * 		  y component to store in the object.
	 */		  
	public Vector2f(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns {@code true} if <i> the current vector</i> and <i> other</i> are
	 * equivalent. Returns {@code false} otherwise.
	 * 
	 * @param other
	 * 		  the vector to compare with
	 * 
	 * @return {@code true} if both vectors are equivalent; 
	 * {@code false} if both vectors are not equivalent.
	 */
	public boolean equals(Vector2f other) {
        return (this.x == other.x && this.y == other.y);
    }
	
	/**
	 * Returns the magnitude (distance from the origin) of <i> the current vector</i>.
	 * Magnitude is also sometimes called the length of a vector.
	 * 
	 * @return the magnitude of <i> the current vector</i>.
	 */
	public float magnitude() {
		return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	
	/**
	 * Makes <i> the current vector</i> have a magnitude of <i> mag</i>,
	 * meaning it keeps the same direction but the distance from 
	 * the origin is <i> mag</i>. 
	 * 
	 * <p> This method directly changes <i> the current vector</i>.
	 * 
	 * @param mag
	 * 		  the float to set the magnitude of <i> the current vector</i> to
	 */
	
	public void setMagnitude(float mag) {
		set((float)(mag/magnitude()*x), (float)(mag/magnitude()*y));
	}
	
	/**
	 * Restricts the x value of <i> the current vector</i> between <i> minX</i>
	 * and <i> maxX</i>, and restricts the y value of <i> the current vector</i> 
	 * between <i> minY</i> and <i> maxY</i>. This directly changes 
	 * <i> the current vector</i>.
	 * 
	 * <p> If x is less than <i> minX</i>, then x is set to <i> minX</i>. 
	 * If x is greater than <i> maxX</i>, then x is set to <i> maxX</i>.
	 * Same process goes for y.
	 * 
	 * @see restricted()
	 * 
	 * @param minX
	 * 		  the minimum value for the x value of <i> the current vector</i>
	 * @param maxX
	 * 		  the maximum value for the x value of <i> the current vector</i>
	 * @param minY
	 * 		  the minimum value for the y value of <i> the current vector</i>
	 * @param maxY
	 * 		  the maximum value for the y value of <i> the current vector</i>
	 */
	public void restrict(float minX, float maxX, float minY, float maxY) {
		set((x > maxX ) ? maxX : ((x < minX) ? minX : x), (y > maxY ) ? maxY : ((y < minY) ? minY : y));
	}
	
	/**
	 * Returns a copy of <i> the current vector</i>, with the x value 
	 * restricted between <i> minX</i> and <i> maxX</i>, and the y 
	 * value restricted between <i> minY</i> and <i> maxY</i>. 
	 * This does not affect <i> the current vector</i>.
	 * 
	 * <p> If x is less than <i> minX</i>, then x is set to <i> minX</i>. 
	 * If x is greater than <i> maxX</i>, then x is set to <i> maxX</i>.
	 * Same process goes for y.
	 * 
	 * @see restrict()
	 * 
	 * @param minX
	 * 		  the minimum value for the x value of the returned vector.
	 * @param maxX
	 * 		  the maximum value for the x value of the returned vector.
	 * @param minY
	 * 		  the minimum value for the y value of the returned vector.
	 * @param maxY
	 * 		  the maximum value for the y value of the returned vector.
	 */
	public Vector2f restricted(float minX, float maxX, float minY, float maxY) {
		return new Vector2f((x > maxX ) ? maxX : ((x < minX) ? minX : x), (x > maxY ) ? maxY : ((x < minY) ? minY : x));
	}
	
	/**
	 * Returns the absolute angle of <i> the current vector</i>, quicker way
	 * of writing: {@code Vector2f.angle(someVector, new Vector2f.up)}. The
	 * formula returns the angle between Vector2f.up (x = 0 and y = 1) and <i> the current vector</i>.
	 * 
	 * @return the absolute angle of <i> the current vector</i>, a float
	 */
	public float absoluteAngle() {
		float angle = (float) ((180/Math.PI)*Math.atan2(1, 0) - (180/Math.PI)*Math.atan2(y, x));
		if(angle != Math.abs(angle)) {
			return 360 + angle;
		}
		return angle;
	}
	
	/**
	 * Returns a formatted string for printing into the console when 
	 * debugging. Quicker way for the user to debug Vector2f objects. 
	 * This string contains the x and y components of <i> the current vector</i> formatted 
	 * like this: {@code x: 0, y: 0}.
	 * 
	 * @see printlnDebugString()
	 * 
	 * @return a string
	 */
	public String debugString() {
		return "x: " + this.x + ", y: " + this.y;
	}
	
	/**
	 * Prints a formatted string containing the x and y components of 
	 * <i> the current vector</i>, directly into the Java console. The print is 
	 * formatted like this: {@code x: 0, y: 0}.
	 * 
	 * @see debugString()
	 */
	public void printlnDebugString() {
		System.out.println("x: " + this.x + ", y: " + this.y);
	}
	
	/**
	 * Sets the x and y components of <i> the current vector</i>. Quicker way for
	 * setting both components apart (on different lines).
	 * 
	 * @param newX
	 * 		  the new x to set the existing x component to.
	 * @param newY
	 * 	      the new y to set the existing y component to.
	 */
	public void set(float newX, float newY) {
		this.x = newX;
		this.y = newY;
	}
	
	/**
	 * Sets the x and y components of <i> the current vector</i> to the x and y
	 * components of the referenced vector.
	 * 
	 * @param target
	 * 		  the referenced vector
	 */
	public void set(Vector2f target) {
		this.x = target.x;
		this.y = target.y;
	}
	
	/**
	 * Makes <i> the current vector</i> have a magnitude of 1, meaning it
	 * keeps its direction but the distance from the origin is 1.0f.
	 * 
	 * <p> This method directly changes <i> the current vector</i>.
	 * 
	 * @see normalized()
	 * 
	 */
	public void normalize() {
		set(1.0f/magnitude()*x, 1.0f/magnitude()*y);
	}
	
	/**
	 * Returns <i> the current vector</i> with a magnitude of one, meaning it 
	 * keeps its direction but the distance from the origin is 1.0f.
	 * 
	 * <p> This method does not change <i> the current vector</i>.
	 * 
	 * @see normalize()
	 * 
	 * @return a new Vector2f object
	 */
	public Vector2f normalized() {
		return new Vector2f(1.0f/magnitude()*x,
				1.0f/magnitude()*y);
	}
	
	/**
	 * Returns a copy of <i> the current vector</i>.
	 * 
	 * @return a copy of <i> the current vector</i>.
	 */
	public Vector2f copy() {
		return new Vector2f(x, y);
	}
	
	/**
	 * Returns the distance between <i> the current vector</i> and <i> target</i>.
	 * 
	 * @param target
	 * 		  the referenced vector
	 * @return the distance to <i> target</i>, a float
	 */
	public float distanceTo(Vector2f target) {
		return (float) Math.sqrt(Math.abs((x - target.x)*(x - target.x) + (y - target.y)*(y - target.y)));
	}
	
	/**
	 * Rotate the vector about the origin, <i> angle</i> degrees, in a
	 * clockwise direction.
	 * 
	 * <p> This method directly rotates (and changes)<i> the current vector</i>.
	 * 
	 * @see rotated()
	 * 
	 * @param angle
	 * 		  the angle to rotate <i> the current vector</i> by.
	 */
	public void rotate(float angle) {
		set((float)(Math.round((float) (x * Math.cos((360-angle)*(Math.PI/180)) - y * Math.sin((360-angle)*(Math.PI/180)))*Math.pow(10, floatPrecisionFactor))/Math.pow(10, floatPrecisionFactor)), 
				(float)(Math.round((float) (x * Math.sin((360-angle)*(Math.PI/180)) + y * Math.cos((360-angle)*(Math.PI/180)))*Math.pow(10, floatPrecisionFactor))/Math.pow(10, floatPrecisionFactor)));
	}
	
	/**
	 * Returns a rotated version of <i> the current vector</i> rotated about 
	 * the origin, <i> angle</i> degrees, in a clockwise direction.
	 * 
	 * <p> This method does not change <i> the current vector</i>.
	 * 
	 * @see rotate()
	 * 
	 * @param angle
	 * 		  the angle to rotate <i> the current vector</i> by.
	 */
	public Vector2f rotated(float angle) {
		return new Vector2f((float)(Math.round((float) (x * Math.cos((360-angle)*(Math.PI/180)) - y * Math.sin((360-angle)*(Math.PI/180)))*Math.pow(10, floatPrecisionFactor))/Math.pow(10, floatPrecisionFactor)), 
				(float)(Math.round((float) (x * Math.sin((360-angle)*(Math.PI/180)) + y * Math.cos((360-angle)*(Math.PI/180)))*Math.pow(10, floatPrecisionFactor))/Math.pow(10, floatPrecisionFactor)));
	}
	
	/**
	 * @category everything below this line until the next category definition is static functions.
	 */
		
	/**
	 * Returns the angle between two vectors, with no negative angles 
	 * meaning reflex angles can be returned. The angle begins at 
	 * <i> from</i> and counts clockwise towards <i> to</i>.
	 * 
	 * @param from
	 * 		  the vector to start the angle
	 * @param to
	 * 		  the vector for the angle to end
	 * 
	 * @return the angle between the vectors, a float
	 */
	public static float angle(Vector2f from, Vector2f to) {
		float angle = (float) ((180/Math.PI)*Math.atan2(from.y, from.x) - (180/Math.PI)*Math.atan2(to.y, to.x));
		if(angle != Math.abs(angle)) {
			return 360 + angle;
		}
		return angle;
	}
	
	/**
	 * Returns the distance between vectors <i> a</i> and <i> b</i>.
	 * 
	 * @param a
	 * 		  a vector
	 * @param b
	 * 	  	  a vector
	 * @return the distance between the vectors, a float
	 */
	public static float distance(Vector2f a, Vector2f b) {
		return (float) Math.sqrt(Math.abs((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y)));
	}
	
	/**
	 * Returns the dot product of two vectors, which is:
	 * <i> from</i> · <i> to</i>. Note that the result will
	 * change if you swap the parameters (the formula becoming 
	 * <i> to</i> · <i> from</i>.)
	 * 
	 * @param from
	 * 		  a vector
	 * @param to
	 * 		  a vector
	 * @return <i> from</i> · <i> to</i>, a float.
	 */
	public static float dotProduct(Vector2f from, Vector2f to) {
		return from.x*to.x + from.y*to.y;
	}
	
	/**
	 * Returns a vector that is moved <i> t</i>/1 of the way from 
	 * vectors a to b. Lerp is short form for Linear Interpolation.
	 * 
	 * <p> t = 0 returns <i> a</i>.
	 * <p> t = 1 returns <i> b</i>.
	 * <p> t = 0.5 returns the midpoint between <i> a</i> and <i> b</i>.
	 * <p> t - 0.2 returns the point 2 tenthes of the way from <i> a</i>
	 * to <i> b</i>.
	 * 
	 * @param a
	 * 		  the vector that defines the starting point
	 * @param b
	 * 		  the vector that defines the ending point
	 * @param t
	 * 		  a float between 0 and 1
	 * @return a new Vector2f object
	 */
	public static Vector2f lerp(Vector2f a, Vector2f b, float t) {
		return new Vector2f(a.x + (b.x - a.x) * t, a.y + (b.y - a.y) * t);
	}
}
