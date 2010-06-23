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
 *This file specifies the information that we will keep about the user
 * @author admin
 */
public interface UserInfoIF {
    /**get the user specified PIN*/
    public String getPIN();
    /**set the PIN to a user specified value
     *@param pin - the value to set
     */
    public void setPIN(String pin);
    /**
     * change PIN
     * @param newPIN - the new PIN
     */
    public void changePIN(String newPIN);
    /**e.g. Eric*/
    public String getFirstName();
    /**e.g. Njogu*/
    public String getLastName();
    /**e.g. Mr.*/
    public String getTitle();
}
