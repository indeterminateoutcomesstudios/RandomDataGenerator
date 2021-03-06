package com.rdg.test.data.util;

import com.rdg.console.print.ConsolePrintUtil;
import com.rdg.constants.Const;
import com.rdg.counter.TimeCounter;
import com.rdg.export.util.ExportXLS;
import com.rdg.internationalizationManager.InternationalizationManager;
import com.rdg.json.util.JSONUtil;
import com.rdg.ormClasses.Worker;
import com.rdg.range.filter.RangeNumberFilter;
import com.rdg.sort.SortUtil;
import com.rdg.util.FilterUtil;
import com.rdg.util.RandomDataUtil;
import com.rdg.util.RandomUtil;
import com.rdg.xml.util.XSteamUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;

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

public class TestDataUtil {
    final static Logger logger = Logger.getLogger(TestDataUtil.class);

    /**
     * creating test data, range number filter, filtering data and printing in console
     */
    public static void printAndTestResultOneFilter() {
        TimeCounter timeCounter = new TimeCounter();
        RandomDataUtil.setDeepLevel(3);
        RandomDataUtil.setNumberOfData(10);
        RandomDataUtil.setNumberOfDataForOneToManyRelation(3);
        RandomDataUtil.setbAllowNulls(Boolean.TRUE);
        RandomDataUtil.setPrecision(Const.FIVE);
        RandomDataUtil.setsPackageFromClass(Const.CLASS_PACKAGE);
        RandomDataUtil.setsPackageFromEnum(Const.ENUM_PACKAGE);
        RandomDataUtil.setsClassName(Worker.class.getName());
        ArrayList<Object> alData;
        alData = RandomDataUtil.getFilledData();
        RangeNumberFilter rangeNumberFilter = RandomDataUtil.getRandomRangeNumberFilter(Worker.class.getSimpleName(), "yearsOfExperienceTotal");
        ConsolePrintUtil.printData(alData);
        alData = FilterUtil.filterRangeDataNumbers(alData, rangeNumberFilter);
        ConsolePrintUtil.printData(alData);
        ConsolePrintUtil.printFilterData(rangeNumberFilter);
        logger.info(timeCounter.printUsedTime());
    }

    /**
     * creating two range number filter, test data, filtering  and printing in console
     */
    public static void printAndTestResultMoreFilters() {
        TimeCounter timeCounter = new TimeCounter();
        RandomDataUtil.setDeepLevel(3);
        RandomDataUtil.setNumberOfData(10);
        RandomDataUtil.setNumberOfDataForOneToManyRelation(3);
        RandomDataUtil.setbAllowNulls(Boolean.TRUE);
        RandomDataUtil.setPrecision(Const.FIVE);
        RandomDataUtil.setsPackageFromClass(Const.CLASS_PACKAGE);
        RandomDataUtil.setsPackageFromEnum(Const.ENUM_PACKAGE);
        RandomDataUtil.setsClassName(Worker.class.getName());
        RangeNumberFilter rangeNumberFilter = RandomDataUtil.getRandomRangeNumberFilter(Worker.class.getSimpleName(), "yearsOfExperienceTotal");
        RangeNumberFilter rangeNumberFilter2 = new RangeNumberFilter("Worker", "age", RandomUtil.getRandomBoolean(Boolean.FALSE), RandomUtil.getRandomBoolean(Boolean.FALSE), RandomUtil.getRandomLong(Const.ZERO_LONG, Long.MAX_VALUE, Boolean.FALSE), RandomUtil.getRandomLong(Const.ZERO_LONG, Long.MAX_VALUE, Boolean.FALSE));
        ArrayList<RangeNumberFilter> alRangeNumberFilters = new ArrayList();
        alRangeNumberFilters.add(rangeNumberFilter);
        alRangeNumberFilters.add(rangeNumberFilter2);
        ArrayList<Object> alData;
        alData = RandomDataUtil.getFilledData();
        ConsolePrintUtil.printData(alData);
        alData = FilterUtil.filterRangeDataNumbers(alData, alRangeNumberFilters);
        ConsolePrintUtil.printData(alData);
        ConsolePrintUtil.printFilterData(alRangeNumberFilters);
        logger.info(timeCounter.printUsedTime());
    }

    /**
     * creating and sorting array list of data and printing in console
     */
    public static void printAndTestResultSortOrder() {
        TimeCounter timeCounter = new TimeCounter();
        ArrayList<Object> alData;
        RandomDataUtil.setDeepLevel(3);
        RandomDataUtil.setNumberOfData(10);
        RandomDataUtil.setNumberOfDataForOneToManyRelation(3);
        RandomDataUtil.setbAllowNulls(Boolean.TRUE);
        RandomDataUtil.setPrecision(Const.FIVE);
        RandomDataUtil.setsPackageFromClass(Const.CLASS_PACKAGE);
        RandomDataUtil.setsPackageFromEnum(Const.ENUM_PACKAGE);
        RandomDataUtil.setsClassName(Worker.class.getName());
        alData = RandomDataUtil.getFilledData();
        ConsolePrintUtil.printData(alData);
        SortUtil sortUtil = new SortUtil("Worker", "age");
        sortUtil.sortBeanByPropertyASC(alData);
        ConsolePrintUtil.printData(alData);
        ConsolePrintUtil.printSortOrder(sortUtil);
        logger.info(timeCounter.printUsedTime());
    }

    /**
     * export objects to xml
     */
    public static void exportObjectsToXML() {
        TimeCounter timeCounter = new TimeCounter();
        ArrayList<Object> alData;
        RandomDataUtil.setDeepLevel(1);
        RandomDataUtil.setNumberOfData(4);
        RandomDataUtil.setNumberOfDataForOneToManyRelation(3);
        RandomDataUtil.setbAllowNulls(Boolean.TRUE);
        RandomDataUtil.setPrecision(Const.FIVE);
        RandomDataUtil.setsPackageFromClass(Const.CLASS_PACKAGE);
        RandomDataUtil.setsPackageFromEnum(Const.ENUM_PACKAGE);
        RandomDataUtil.setsClassName(Worker.class.getName());
        alData = RandomDataUtil.getFilledData();
        ConsolePrintUtil.printData(alData);
        if (alData != null) {
            for (int i = 0; i < alData.size(); i++) {
                Worker object = (Worker) alData.get(i);
                XSteamUtil.xSteamObjectToXML(object, XSteamUtil.getFILE_NAME() + i + Const.DOT_DELIMITER + Const.XML);
            }
        }
        logger.info(timeCounter.printUsedTime());
    }

    /**
     * xml to objects
     */
    public static void XMLToObject() {
        TimeCounter timeCounter = new TimeCounter();
        ArrayList<Object> alData = new ArrayList();
        int i = 0;
        Object object;
        while ((object = XSteamUtil.xSteamXMLToObject(XSteamUtil.getFILE_NAME() + i + Const.DOT_DELIMITER + Const.XML)) != null) {
            alData.add(object);
            i++;
        }
        ConsolePrintUtil.printData(alData);
        logger.info(timeCounter.printUsedTime());
    }

    /**
     * json objects to xml
     */
    public static void exportObjectsToJSON() {
        TimeCounter timeCounter = new TimeCounter();
        ArrayList<Object> alData;
        RandomDataUtil.setDeepLevel(1);
        RandomDataUtil.setNumberOfData(4);
        RandomDataUtil.setNumberOfDataForOneToManyRelation(3);
        RandomDataUtil.setbAllowNulls(Boolean.TRUE);
        RandomDataUtil.setPrecision(Const.FIVE);
        RandomDataUtil.setsPackageFromClass(Const.CLASS_PACKAGE);
        RandomDataUtil.setsPackageFromEnum(Const.ENUM_PACKAGE);
        RandomDataUtil.setsClassName(Worker.class.getName());
        alData = RandomDataUtil.getFilledData();
        ConsolePrintUtil.printData(alData);
        if (alData != null) {
            for (int i = 0; i < alData.size(); i++) {
                Object object = alData.get(i);
                JSONUtil.objectToJSON(object, JSONUtil.getFILE_NAME() + i + Const.DOT_DELIMITER + Const.JSON);
            }
        }
        logger.info(timeCounter.printUsedTime());
    }

    /**
     * json to objects
     */
    public static void JSONToObject() {
        TimeCounter timeCounter = new TimeCounter();
        ArrayList<Object> alData = new ArrayList();
        int i = 0;
        Class cl = null;
        try {
            cl = Class.forName(RandomDataUtil.getsClassName());
        } catch (ClassNotFoundException e) {
            logger.error(InternationalizationManager.getString(Const.CLASS_NOT_EXIST) + "[" + RandomDataUtil.getsClassName() + "] ");
        }
        Object object;
        while ((object = JSONUtil.JSONToObject(JSONUtil.getFILE_NAME() + i + Const.DOT_DELIMITER + Const.JSON, cl)) != null) {
            alData.add(object);
            i++;
        }
        ConsolePrintUtil.printData(alData);
        logger.info(timeCounter.printUsedTime());
    }

    /**
     * export objects to xsl
     */
    public static void exportXMLtoXSL() {
        TimeCounter timeCounter = new TimeCounter();
        ArrayList<Object> alData;
        RandomDataUtil.setDeepLevel(3);
        RandomDataUtil.setNumberOfData(10);
        RandomDataUtil.setNumberOfDataForOneToManyRelation(3);
        RandomDataUtil.setbAllowNulls(Boolean.TRUE);
        RandomDataUtil.setPrecision(Const.FIVE);
        RandomDataUtil.setsPackageFromClass(Const.CLASS_PACKAGE);
        RandomDataUtil.setsPackageFromEnum(Const.ENUM_PACKAGE);
        RandomDataUtil.setsClassName(Worker.class.getName());
        alData = RandomDataUtil.getFilledData();
        ExportXLS.exportXLSPOI(alData);
        logger.info(timeCounter.printUsedTime());
    }

//	/**
//	 * create jasper report
//	 */
//	public static void createJasperReport() {
//		TimeCounter timeCounter = new TimeCounter();
//        System.setProperty("java.awt.headless", "true");
//		ArrayList<Object> alData;
//		RandomDataUtil.setDeepLevel(3);
//		RandomDataUtil.setNumberOfData(10);
//		RandomDataUtil.setNumberOfDataForOneToManyRelation(3);
//		RandomDataUtil.setbAllowNulls(Boolean.FALSE);
//		RandomDataUtil.setPrecision(Const.FIVE);
//		RandomDataUtil.setsPackageFromClass(Const.CLASS_PACKAGE);
//        RandomDataUtil.setsPackageFromEnum(Const.ENUM_PACKAGE);
//		RandomDataUtil.setsClassName(Worker.class.getName());
//		alData = RandomDataUtil.getFilledData();
//		JasperReportsUtil.getReport(alData);
//		logger.info(timeCounter.printUsedTime());
//	}
//	/**
//	 * create jasper report and export to PDF
//	 */
//	public static void createJasperReportExportPDF() {
//		TimeCounter timeCounter = new TimeCounter();
//		ArrayList<Object> alData;
//		RandomDataUtil.setDeepLevel(3);
//		RandomDataUtil.setNumberOfData(10);
//		RandomDataUtil.setNumberOfDataForOneToManyRelation(3);
//		RandomDataUtil.setbAllowNulls(Boolean.FALSE);
//		RandomDataUtil.setPrecision(Const.FIVE);
//		RandomDataUtil.setsPackageFromClass(Const.CLASS_PACKAGE);
//        RandomDataUtil.setsPackageFromEnum(Const.ENUM_PACKAGE);
//		RandomDataUtil.setsClassName(Worker.class.getName());
//		alData = RandomDataUtil.getFilledData();
//		JasperReportsUtil.exportToPDF(alData);
//		logger.info(timeCounter.printUsedTime());
//	}
//
//
//	/**
//	 * create jasper report and export to XSL
//	 */
//	public static void createJasperReportExportXSL() {
//		TimeCounter timeCounter = new TimeCounter();
//		ArrayList<Object> alData =  new ArrayList<Object>();
//		RandomDataUtil.setDeepLevel(3);
//		RandomDataUtil.setNumberOfData(10);
//		RandomDataUtil.setNumberOfDataForOneToManyRelation(3);
//		RandomDataUtil.setbAllowNulls(Boolean.FALSE);
//		RandomDataUtil.setPrecision(Const.FIVE);
//		RandomDataUtil.setsPackageFromClass(Const.CLASS_PACKAGE);
//      RandomDataUtil.setsPackageFromEnum(Const.ENUM_PACKAGE);
//		RandomDataUtil.setsClassName(Worker.class.getName());
//		alData = RandomDataUtil.getFilledData();
//		JasperReportsUtil.exportToXSL(alData);
//		logger.info(timeCounter.printUsedTime());
//	}
}
