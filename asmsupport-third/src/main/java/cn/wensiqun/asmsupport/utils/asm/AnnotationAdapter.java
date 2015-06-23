/**    
 *  Asmsupport is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cn.wensiqun.asmsupport.utils.asm;

import cn.wensiqun.asmsupport.org.objectweb.asm.AnnotationVisitor;
import cn.wensiqun.asmsupport.utils.AsmsupportConstant;

public class AnnotationAdapter extends AnnotationVisitor {

	public AnnotationAdapter(AnnotationVisitor av) {
		super(AsmsupportConstant.ASM_VERSION, av);
	}

	public AnnotationAdapter() {
		super(AsmsupportConstant.ASM_VERSION);
	}

	
	
}