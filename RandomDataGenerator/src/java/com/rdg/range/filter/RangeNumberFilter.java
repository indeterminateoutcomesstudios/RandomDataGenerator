package com.rdg.range.filter;

/*
* Copyright 2014 Radislav Tapavicki <radislavtt@gmail.com>
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

public class RangeNumberFilter extends RangeFilter<Long> {
    public RangeNumberFilter() {
    }

    public RangeNumberFilter(String nameOfTheClass, String property, Boolean isInRange, Boolean allowNull, Long rangeFrom, Long rangeTo) {
        super(nameOfTheClass, property, isInRange, allowNull, rangeFrom, rangeTo);
    }
}
