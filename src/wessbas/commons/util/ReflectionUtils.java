package wessbas.commons.util;

import java.lang.reflect.Method;

/**
 * Utility functions related to reflection.
 * 
 * @author robert.heilein@in.tum.de
 */

public class ReflectionUtils
{
	// -----
	// ----- Public
	// -----

	/**
	 * Calls the main method of the provided class name.
	 * 
	 * @param strClassName
	 *            Class that contains a main method.
	 * @param strArgumentArray
	 *            Argument of the main method.
	 * @return true, if the method call was successful, false otherwise.
	 */

	public static boolean callMain( String strClassName, String[] strArgumentArray )
	{
		try
		{
			Class< ? > clazz = Class.forName( strClassName );
			Method method = clazz.getMethod( "main", String[].class );
			method.invoke( null, new Object[] { strArgumentArray } );

			return true;
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}

		return false;
	}
}
