/*
 * file:       ResourceNumbersTest.java
 * author:     Jon Iles
 * copyright:  (c) Packwood Software 2017
 * date:       08/03/2017
 */

/*
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation; either version 2.1 of the License, or (at your
 * option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */

package net.sf.mpxj.junit.resource;

import static net.sf.mpxj.junit.MpxjAssert.*;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;
import net.sf.mpxj.common.NumberHelper;
import net.sf.mpxj.junit.MpxjTestData;
import net.sf.mpxj.mpd.MPDDatabaseReader;
import net.sf.mpxj.mpx.MPXReader;
import net.sf.mpxj.reader.ProjectReader;
import net.sf.mpxj.reader.ProjectReaderUtility;

/**
 * Tests to ensure task custom numbers are correctly handled.
 */
public class ResourceNumbersTest
{
   /**
    * Test to validate the custom numbers in files saved by different versions of MS Project.
    */
   @Test public void testResourceNumbers() throws MPXJException
   {
      for (File file : MpxjTestData.listFiles("generated/resource-numbers", "resource-numbers"))
      {
         testResourceNumbers(file);
      }
   }

   /**
    * Test an individual project.
    *
    * @param file project file
    */
   private void testResourceNumbers(File file) throws MPXJException
   {
      ProjectReader reader = ProjectReaderUtility.getProjectReader(file.getName());
      if (reader instanceof MPDDatabaseReader)
      {
         assumeJvm();
      }

      int maxIndex = reader instanceof MPXReader ? 5 : 20;
      ProjectFile project = reader.read(file);
      for (int index = 1; index <= maxIndex; index++)
      {
         Resource resource = project.getResourceByID(Integer.valueOf(index));
         assertEquals("Number" + index, resource.getName());
         testResourceNumbers(file, resource, index, maxIndex);
      }
   }

   /**
    * Test the number values for a resource.
    *
    * @param file parent file
    * @param resource resource
    * @param testIndex index of number being tested
    * @param maxIndex maximum number of custom fields to expect in this file
    */
   private void testResourceNumbers(File file, Resource resource, int testIndex, int maxIndex)
   {
      for (int index = 1; index <= maxIndex; index++)
      {
         int expectedValue = testIndex == index ? index : 0;
         int actualValue = NumberHelper.getInt(resource.getNumber(index));

         assertEquals(file.getName() + " Number" + index, expectedValue, actualValue);
      }
   }
}
