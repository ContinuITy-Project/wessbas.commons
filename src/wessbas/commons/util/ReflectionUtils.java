/***************************************************************************
 * Copyright (c) 2016 the WESSBAS project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************/


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
