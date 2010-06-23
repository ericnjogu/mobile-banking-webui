/*
   Copyright [2010] [Eric Njogu]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.IF;

/**
 *abstracts the process of getting locale specific strings
 * @author enjogu
 */
public interface Locale {
    /**
     * @param constant - the key that acts as an index to the info
     * @return the locale specific string
     */
    public String getString(String constant);
    /**
     * 
     * @param constant - the key
     * @param params - the parameters to be substituted into the return string
     * @return
     */
    public String getString(String constant, Object[] params);
}
