/*
 * SmartTestAutoFramework
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

import smartfwk.testing.ui.core.events.InputEvent;
import smartfwk.testing.ui.core.objects.UIObject;

/**
 * 
 * @author Madhav Krishna
 *
 */
@SuppressWarnings("rawtypes")
public class PathItem {
	private UIObject item;
	
	
	private InputEvent event;

	public PathItem(UIObject item, InputEvent event) {
		this.item = item;
		this.event = event;
	}

	public UIObject getItem() {
		return item;
	}

	public InputEvent getEvent() {
		return event;
	}
}
