package net.crimson.java.math;

/**
 * This class can represent vectors and points in 2D space. This can be used 
 * to store positions, directions, rotations, and more. Subclass of 
 * Vector. Contains a variety of functions to work with vectors.
 * For vectors and points in 3D space, use Vector3f.
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
	 * Quicker way for writing {@code Vector2f(0, 0)}.
	 */
	public static final Vector2f zero = new Vector2f(0, 0);
	
	/** 
	 * Quicker way for writing {@code Vector2f(1, 1)}.
	 */
	public static final Vector2f one = new Vector2f(1, 1);
	
	/** 
	 * Quicker way for writing {@code Vector2f(-1, -1)}.
	 */
	public static final Vector2f negativeOne = new Vector2f(-1, -1);
	
	/** 
	 * Quicker way for writing a Vector2f pointing up ({@code Vector2f(0, 1)}).
	 */
	public static final Vector2f up = new Vector2f(0, 1);
	
	/** 
	 * Quicker way for writing a Vector2f pointing down ({@code Vector2f(0, -1)}).
	 */
	public static final Vector2f down = new Vector2f(0, -1);
	
	/** 
	 * Quicker way for writing a Vector2f pointing left ({@code Vector2f(-1, 0)}).
	 */
	public static final Vector2f left = new Vector2f(-1, 0);
	
	/** 
	 * Quicker way for writing a Vector2f pointing right ({@code Vector2f(1, 0)}).
	 */
	public static final Vector2f right = new Vector2f(1, 0);
	
	/**
	 * Constructor for the Vector2f, setting the x and y components to
	 * the provided parameters.
	 * 
	 * @param x
	 * 		  x component to store in the vector.
	 * @param y
	 * 		  y component to store in the vector.
	 */		  
	public Vector2f(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns {@code true} if <i> this vector</i> and the given vector are
	 * equivalent. Returns {@code false} otherwise.
	 * 
	 * @param other
	 * 		  the given vector
	 * 
	 * @return {@code true} if both vectors are equivalent,
	 * {@code false} if otherwise.
	 */
	public boolean equals(Vector2f other) {
        return (this.x == other.x && this.y == other.y);
    }
	
	/**
	 * Returns the magnitude (distance from the origin) of <i> this vector</i>.
	 * Magnitude is also sometimes called the length of a vector.
	 * 
	 * @return the magnitude of <i> this vector</i>.
	 */
	public float magnitude() {
		return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	
	/**
	 * Makes <i> this vector</i> have a magnitude of the given magnitude,
	 * meaning it keeps the same direction but the distance from 
	 * the origin is the given magnitude. 
	 * 
	 * <p> This method directly changes <i> this vector</i>.
	 * 
	 * @param mag
	 * 		  the given magnitude (float)
	 */
	
	public void setMagnitude(float mag) {
		set((float)(mag/magnitude()*x), (float)(mag/magnitude()*y));
	}
	
	/**
	 * Restricts the x value of <i> this vector</i> between <i> minX</i>
	 * and <i> maxX</i>, and restricts the y value of <i> this vector</i> 
	 * between <i> minY</i> and <i> maxY</i>. This directly changes 
	 * <i> this vector</i>.
	 * 
	 * <p> If x is less than <i> minX</i>, then x is set to <i> minX</i>. 
	 * If x is greater than <i> maxX</i>, then x is set to <i> maxX</i>.
	 * Same process goes for y.
	 * 
	 * @see restricted(float minX, float maxX, float minY, float maxY)
	 * 
	 * @param minX
	 * 		  the minimum value for the x value of <i> this vector</i>
	 * @param maxX
	 * 		  the maximum value for the x value of <i> this vector</i>
	 * @param minY
	 * 		  the minimum value for the y value of <i> this vector</i>
	 * @param maxY
	 * 		  the maximum value for the y value of <i> this vector</i>
	 */
	public void restrict(float minX, float maxX, float minY, float maxY) {
		set((x > maxX ) ? maxX : ((x < minX) ? minX : x), (y > maxY ) ? maxY : ((y < minY) ? minY : y));
	}
	
	/**
	 * Returns a copy of <i> this vector</i>, with the x value 
	 * restricted between <i> minX</i> and <i> maxX</i>, and the y 
	 * value restricted between <i> minY</i> and <i> maxY</i>. 
	 * This does not affect <i> this vector</i>.
	 * 
	 * <p> If x is less than <i> minX</i>, then x is set to <i> minX</i>. 
	 * If x is greater than <i> maxX</i>, then x is set to <i> maxX</i>.
	 * Same process goes for y.
	 * 
	 * @see restrict(float minX, float maxX, float minY, float maxY)
	 * 
	 * @param minX
	 * 		  the minimum value for the x value of the returned vector.
	 * @param maxX
	 * 		  the maximum value for the x value of the returned vector.
	 * @param minY
	 * 		  the minimum value for the y value of the returned vector.
	 * @param maxY
	 * 		  the maximum value for the y value of the returned vector.
	 * 
	 * @return a new Vector2f object.
	 */
	public Vector2f restricted(float minX, float maxX, float minY, float maxY) {
		return new Vector2f((x > maxX ) ? maxX : ((x < minX) ? minX : x), (x > maxY ) ? maxY : ((x < minY) ? minY : x));
	}
	
	/**
	 * Returns the absolute angle of <i> this vector</i>, quicker way
	 * of writing: {@code Vector2f.angle(someVector, Vector2f.up)}.
	 * 
	 * @return the absolute angle of <i> this vector</i>, a float
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
	 * This string contains the x and y components of <i> this vector</i> formatted 
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
	 * <i> this vector</i>, directly into the Java console. The print is 
	 * formatted like this: {@code x: 0, y: 0}.
	 * 
	 * @see debugString()
	 */
	public void printlnDebugString() {
		System.out.println("x: " + this.x + ", y: " + this.y);
	}
	
	/**
	 * Sets the x and y components of <i> this vector</i> to the given x and y. Quicker than
	 * setting both components apart (on different lines).
	 * 
	 * @param newX
	 * 		  the new x
	 * @param newY
	 * 	      the new y
	 */
	public void set(float newX, float newY) {
		this.x = newX;
		this.y = newY;
	}
	
	/**
	 * Sets the x and y components of <i> this vector</i> to the x and y
	 * components of the given vector.
	 * 
	 * @param target
	 * 		  the given vector
	 */
	public void set(Vector2f target) {
		this.x = target.x;
		this.y = target.y;
	}
	
	/**
	 * Makes <i> this vector</i> have a magnitude of 1, meaning it
	 * keeps its direction but the distance from the origin is 1.0f.
	 * 
	 * <p> This method directly changes <i> this vector</i>.
	 * 
	 * @see normalized()
	 * 
	 */
	public void normalize() {
		set(x/magnitude(), y/magnitude());
	}
	
	/**
	 * Returns <i> this vector</i> with a magnitude of one, meaning it 
	 * keeps its direction but the distance from the origin is 1.0f.
	 * 
	 * <p> This method does not change <i> this vector</i>.
	 * 
	 * @see normalize()
	 * 
	 * @return a new Vector2f object
	 */
	public Vector2f normalized() {
		return new Vector2f(x/magnitude(),
				y/magnitude());
	}
	
	/**
	 * Returns a copy of <i> this vector</i>.
	 * 
	 * @return a copy of <i> this vector</i>.
	 */
	public Vector2f copy() {
		return new Vector2f(x, y);
	}
	
	/**
	 * Returns the distance between <i> this vector</i> and the given vector.
	 * 
	 * @param target
	 * 		  the given vector
	 * @return the distance to the given vector.
	 */
	public float distanceTo(Vector2f target) {
		return (float) Math.sqrt(Math.abs((x - target.x)*(x - target.x) + (y - target.y)*(y - target.y)));
	}
	
	/**
	 * Rotate <i> this vector</i> about the origin, some number of degrees, in a
	 * clockwise direction (negative degrees for counterclockwise rotation).
	 * 
	 * <p> This method directly rotates (and changes)<i> this vector</i>.
	 * 
	 * @see rotated(float degrees)
	 * 
	 * @param degrees
	 * 		  the number of degrees to rotate by
	 */
	public void rotate(float degrees) {
		float radians = (float) ( (360-degrees)*(Math.PI/180) );
		set((float) (x * Math.cos(radians) - y * Math.sin(radians)), 
				(float) (x * Math.sin(radians) + y * Math.cos(radians)));
	}
	
	/**
	 * Returns a rotated version of <i> this vector</i> rotated about 
	 * the origin, some number of degrees, in a clockwise direction
	 * (negative degrees for counterclockwise rotation).
	 * 
	 * <p> This method does not change <i> this vector</i>.
	 * 
	 * @see rotate(float degrees)
	 * 
	 * @param degrees
	 * 		  the number of degrees to rotate by
	 * 
	 * @return a new Vector2f object.
	 */
	public Vector2f rotated(float degrees) {
		float degInRad = (float) ( (360-degrees)*(Math.PI/180) );
		return new Vector2f((float) (x * Math.cos(degInRad) - y * Math.sin(degInRad)), 
				(float) (x * Math.sin(degInRad) + y * Math.cos(degInRad)));
	}
	
	/**
	 * Moves <i> this vector</i> in the direction of another vector 
	 * some distance.
	 * 
	 * @param target
	 * 		  the referenced vector
	 * @param distance
	 * 		  the distance to move
	 */
	public void moveTowards(Vector2f target, float distance) {
		Vector2f movementVector = new Vector2f(target.x-this.x, target.y-this.y);
		movementVector.normalize();
		movementVector.setMagnitude(distance);
		add(movementVector);
	}
	
	/**
	 * Multiplies <i> this vector</i> by another vector. Quicker way to write {@code someVector.x *= otherVector.x; someVector.y *= otherVector.y;}.
	 * 
	 * <p> This method directly changes <i> this vector</i>.
	 * 
	 * @param other
	 * 		  the given vector
	 */
	public void mult(Vector2f other) {
		set(x*other.x, y*other.y);
	}
	
	/**
	 * Multiplies both the x and y components of <i> this vector</i> by a given number.
	 * 
	 * <p> This method directly changes <i> this vector</i>.
	 * 
	 * @param num
	 * 		  the given number
	 */
	public void mult(float num) {
		set(x*num, y*num);
	}
	
	/**
	 * Adds <i> this vector</i> to another vector. Quicker way to write {@code someVector.x += otherVector.x; someVector.y += otherVector.y;}.
	 * 
	 * <p> This method directly changes <i> this vector</i>.
	 * 
	 * @param other
	 * 		  the given vector
	 */
	public void add(Vector2f other) {
		set(x+other.x, y+other.y);
	}
	
	/**
	 * Adds a given number to both the x and y components of <i> this vector</i>.
	 * 
	 * <p> This method directly changes <i> this vector</i>.
	 * 
	 * @param num
	 * 		  the given number
	 */
	public void add(float num) {
		set(x+num, y+num);
	}
	
	/**
	 * Subtracts another vector from <i> this vector</i>. Quicker way to write {@code someVector.x -= otherVector.x; someVector.y -= otherVector.y;}.
	 * 
	 * <p> This method directly changes <i> this vector</i>.
	 * 
	 * @param other
	 * 		  the given vector
	 */
	public void subt(Vector2f other) {
		set(x-other.x, y-other.y);
	}
	
	/**
	 * Subtracts a given number from both the x and y components of <i> this vector</i>.
	 * 
	 * <p> This method directly changes <i> this vector</i>.
	 * 
	 * @param num
	 * 		  the given number
	 */
	public void subt(float num) {
		set(x-num, y-num);
	}
	
	/**
	 * Divides <i> this vector</i> by another vector. Quicker way to write {@code someVector.x /= otherVector.x; someVector.y /= otherVector.y;}.
	 * 
	 * <p> This method directly changes <i> this vector</i>.
	 * 
	 * @param other
	 * 		  the given vector
	 */
	public void div(Vector2f other) {
		set(x/other.x, y/other.y);
	}
	
	/**
	 * Divides both the x and y components of <i> this vector</i> by a given number.
	 * 
	 * <p> This method directly changes <i> this vector</i>.
	 * 
	 * @param num
	 * 		  the given number
	 */
	public void div(float num) {
		set(x/num, y/num);
	}
	
	/**
	 * @category everything below this line until the next category definition is static functions.
	 */
		
	/**
	 * Returns the angle between two vectors, with no negative angles 
	 * meaning reflex angles can be returned. The angle begins at 
	 * the vector to start the angle and counts clockwise towards 
	 * the vector for the angle to end.
	 * 
	 * @param from
	 * 		  the vector to start the angle
	 * @param to
	 * 		  the vector for the angle to end
	 * 
	 * @return the angle between the vectors.
	 */
	public static float angle(Vector2f from, Vector2f to) {
		float angle = (float) ((180/Math.PI)*Math.atan2(from.y, from.x) - (180/Math.PI)*Math.atan2(to.y, to.x));
		if(angle != Math.abs(angle)) {
			return 360 + angle;
		}
		return angle;
	}
	
	/**
	 * Returns the distance between the given vectors.
	 * 
	 * @param a
	 * 		  a vector
	 * @param b
	 * 	  	  a vector
	 * @return the distance between the vectors.
	 */
	public static float distance(Vector2f a, Vector2f b) {
		return (float) Math.sqrt(Math.abs((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y)));
	}
	
	/**
	 * Returns the dot product of two vectors, which is:
	 * <i> a</i> · <i> b</i>. The dot product is a single 
	 * number which is equal to the two vectors multiplied 
	 * together, then multiplied by the cosine of the angle 
	 * between them.
	 * 
	 * @param a
	 * 		  a vector
	 * @param b
	 * 		  a vector
	 * @return the dot product of the given vectors.
	 */
	public static float dotProduct(Vector2f a, Vector2f b) {
		return a.x*b.x + a.y*b.y;
	}
	
	/**
	 * Returns the cross product of two vectors (also called the "perpendicular dot product"), which is:
	 * <i> a</i> × <i> b</i>.  Note that the result will
	 * change if you swap the parameters. The cross product is a single 
	 * number which is equal to the two vectors multiplied 
	 * together, then multiplied by the sine of the angle 
	 * between them.
	 * @param a
	 * 		  a vector
	 * @param b
	 * 		  a vector
	 * @return the cross product of the given vectors.
	 */
	public static float crossProduct(Vector2f a, Vector2f b) {
		return a.x*b.y - a.y*b.x;
	}
	
	/**
	 * Returns a vector that is moved <i> t</i>/1 of the way from 
	 * vectors <i> a</i> to <i> b</i>. Lerp is short form for Linear Interpolation.
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
	 * @return a new Vector2f object.
	 */
	public static Vector2f lerp(Vector2f a, Vector2f b, float t) {
		return new Vector2f(a.x + (b.x - a.x) * t, a.y + (b.y - a.y) * t);
	}
}
