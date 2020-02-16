/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.spring.githubactionsdashboard.domain;

import java.util.ArrayList;
import java.util.List;

public class Branch {

	private String name;
	private String url;
	private List<CheckRun> checkRuns = new ArrayList<>();

	public Branch() {
	}

	public Branch(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public Branch(String name, String url, List<CheckRun> checkRuns) {
		this.name = name;
		this.url = url;
		this.checkRuns = checkRuns;
	}

	public static Branch of(String name, String url) {
		return new Branch(name, url);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<CheckRun> getCheckRuns() {
		return checkRuns;
	}

	public void setCheckRuns(List<CheckRun> checkRuns) {
		this.checkRuns = checkRuns;
	}
}
