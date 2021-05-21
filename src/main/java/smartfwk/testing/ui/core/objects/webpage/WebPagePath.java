/*
 * SmartTestAutoFwk
 * Copyright 2021 and beyond
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
 * 
 */
package smartfwk.testing.ui.core.objects.webpage;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Madhav Krishna
 *
 */
public class WebPagePath {
	private List<PathItem> path;
	
	public WebPagePath() {
		path = new ArrayList<PathItem>(10);
	}
	
	public WebPagePath append(PathItem pathItem) {
		path.add(pathItem);
		return this;
	}
	
	public List<PathItem> getPath() {
		return path;
	}

}
