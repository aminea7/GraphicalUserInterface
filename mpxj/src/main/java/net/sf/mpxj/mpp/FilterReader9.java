/*
 * file:       FilterReader9.java
 * author:     Jon Iles
 * copyright:  (c) Packwood Software 2006
 * date:       2006-10-31
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

package net.sf.mpxj.mpp;

/**
 * This class allows filter definitions to be read from an MPP9 file.
 */
public final class FilterReader9 extends FilterReader
{
   /**
    * {@inheritDoc}
    */
   @Override protected Integer getVarDataType()
   {
      return (FILTER_DATA);
   }

   /**
    * {@inheritDoc}
    */
   @Override protected CriteriaReader getCriteriaReader()
   {
      return m_criteraReader;
   }

   private CriteriaReader m_criteraReader = new FilterCriteriaReader9();
   private static final Integer FILTER_DATA = Integer.valueOf(1);
}
