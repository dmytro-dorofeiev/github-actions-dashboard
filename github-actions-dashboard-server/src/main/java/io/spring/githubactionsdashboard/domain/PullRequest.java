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

public class PullRequest {

	private String name;
	private Integer number;
	private String url;
	private List<CheckRun> checkRuns = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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

	@Override
	public String toString() {
		return "PullRequest [checkRuns=" + checkRuns + ", name=" + name + ", number=" + number + ", url=" + url + "]";
	}
}
