package com.example.sphtest.Utils

import DataUsageResponse
import com.example.sphtest.extensions.toGson

object MockData {
    fun loadResponse(): DataUsageResponse {
        val data = "{\n" +
                "  \"help\": \"https://data.gov.sg/api/3/action/help_show?name=datastore_search\",\n" +
                "  \"success\": true,\n" +
                "  \"result\": {\n" +
                "    \"resource_id\": \"a807b7ab-6cad-4aa6-87d0-e283a7353a0f\",\n" +
                "    \"fields\": [\n" +
                "      {\n" +
                "        \"type\": \"int4\",\n" +
                "        \"id\": \"_id\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"text\",\n" +
                "        \"id\": \"quarter\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"numeric\",\n" +
                "        \"id\": \"volume_of_mobile_data\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"records\": [\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.000384\",\n" +
                "        \"quarter\": \"2004-Q3\",\n" +
                "        \"_id\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.000543\",\n" +
                "        \"quarter\": \"2004-Q4\",\n" +
                "        \"_id\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.00062\",\n" +
                "        \"quarter\": \"2005-Q1\",\n" +
                "        \"_id\": 3\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.000634\",\n" +
                "        \"quarter\": \"2005-Q2\",\n" +
                "        \"_id\": 4\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.000718\",\n" +
                "        \"quarter\": \"2005-Q3\",\n" +
                "        \"_id\": 5\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.000801\",\n" +
                "        \"quarter\": \"2005-Q4\",\n" +
                "        \"_id\": 6\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.00089\",\n" +
                "        \"quarter\": \"2006-Q1\",\n" +
                "        \"_id\": 7\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.001189\",\n" +
                "        \"quarter\": \"2006-Q2\",\n" +
                "        \"_id\": 8\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.001735\",\n" +
                "        \"quarter\": \"2006-Q3\",\n" +
                "        \"_id\": 9\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.003323\",\n" +
                "        \"quarter\": \"2006-Q4\",\n" +
                "        \"_id\": 10\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.012635\",\n" +
                "        \"quarter\": \"2007-Q1\",\n" +
                "        \"_id\": 11\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.029992\",\n" +
                "        \"quarter\": \"2007-Q2\",\n" +
                "        \"_id\": 12\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.053584\",\n" +
                "        \"quarter\": \"2007-Q3\",\n" +
                "        \"_id\": 13\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.100934\",\n" +
                "        \"quarter\": \"2007-Q4\",\n" +
                "        \"_id\": 14\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.171586\",\n" +
                "        \"quarter\": \"2008-Q1\",\n" +
                "        \"_id\": 15\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.248899\",\n" +
                "        \"quarter\": \"2008-Q2\",\n" +
                "        \"_id\": 16\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.439655\",\n" +
                "        \"quarter\": \"2008-Q3\",\n" +
                "        \"_id\": 17\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"0.683579\",\n" +
                "        \"quarter\": \"2008-Q4\",\n" +
                "        \"_id\": 18\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"1.066517\",\n" +
                "        \"quarter\": \"2009-Q1\",\n" +
                "        \"_id\": 19\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"1.357248\",\n" +
                "        \"quarter\": \"2009-Q2\",\n" +
                "        \"_id\": 20\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"1.695704\",\n" +
                "        \"quarter\": \"2009-Q3\",\n" +
                "        \"_id\": 21\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"2.109516\",\n" +
                "        \"quarter\": \"2009-Q4\",\n" +
                "        \"_id\": 22\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"2.3363\",\n" +
                "        \"quarter\": \"2010-Q1\",\n" +
                "        \"_id\": 23\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"2.777817\",\n" +
                "        \"quarter\": \"2010-Q2\",\n" +
                "        \"_id\": 24\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"3.002091\",\n" +
                "        \"quarter\": \"2010-Q3\",\n" +
                "        \"_id\": 25\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"3.336984\",\n" +
                "        \"quarter\": \"2010-Q4\",\n" +
                "        \"_id\": 26\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"3.466228\",\n" +
                "        \"quarter\": \"2011-Q1\",\n" +
                "        \"_id\": 27\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"3.380723\",\n" +
                "        \"quarter\": \"2011-Q2\",\n" +
                "        \"_id\": 28\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"3.713792\",\n" +
                "        \"quarter\": \"2011-Q3\",\n" +
                "        \"_id\": 29\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"4.07796\",\n" +
                "        \"quarter\": \"2011-Q4\",\n" +
                "        \"_id\": 30\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"4.679465\",\n" +
                "        \"quarter\": \"2012-Q1\",\n" +
                "        \"_id\": 31\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"5.331562\",\n" +
                "        \"quarter\": \"2012-Q2\",\n" +
                "        \"_id\": 32\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"5.614201\",\n" +
                "        \"quarter\": \"2012-Q3\",\n" +
                "        \"_id\": 33\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"5.903005\",\n" +
                "        \"quarter\": \"2012-Q4\",\n" +
                "        \"_id\": 34\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"5.807872\",\n" +
                "        \"quarter\": \"2013-Q1\",\n" +
                "        \"_id\": 35\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"7.053642\",\n" +
                "        \"quarter\": \"2013-Q2\",\n" +
                "        \"_id\": 36\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"7.970536\",\n" +
                "        \"quarter\": \"2013-Q3\",\n" +
                "        \"_id\": 37\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"7.664802\",\n" +
                "        \"quarter\": \"2013-Q4\",\n" +
                "        \"_id\": 38\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"7.73018\",\n" +
                "        \"quarter\": \"2014-Q1\",\n" +
                "        \"_id\": 39\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"7.907798\",\n" +
                "        \"quarter\": \"2014-Q2\",\n" +
                "        \"_id\": 40\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"8.629095\",\n" +
                "        \"quarter\": \"2014-Q3\",\n" +
                "        \"_id\": 41\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"9.327967\",\n" +
                "        \"quarter\": \"2014-Q4\",\n" +
                "        \"_id\": 42\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"9.687363\",\n" +
                "        \"quarter\": \"2015-Q1\",\n" +
                "        \"_id\": 43\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"9.98677\",\n" +
                "        \"quarter\": \"2015-Q2\",\n" +
                "        \"_id\": 44\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"10.902194\",\n" +
                "        \"quarter\": \"2015-Q3\",\n" +
                "        \"_id\": 45\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"10.677166\",\n" +
                "        \"quarter\": \"2015-Q4\",\n" +
                "        \"_id\": 46\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"10.96733\",\n" +
                "        \"quarter\": \"2016-Q1\",\n" +
                "        \"_id\": 47\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"11.38734\",\n" +
                "        \"quarter\": \"2016-Q2\",\n" +
                "        \"_id\": 48\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"12.14232\",\n" +
                "        \"quarter\": \"2016-Q3\",\n" +
                "        \"_id\": 49\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"12.86429\",\n" +
                "        \"quarter\": \"2016-Q4\",\n" +
                "        \"_id\": 50\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"13.29757\",\n" +
                "        \"quarter\": \"2017-Q1\",\n" +
                "        \"_id\": 51\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"14.54179\",\n" +
                "        \"quarter\": \"2017-Q2\",\n" +
                "        \"_id\": 52\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"14.88463\",\n" +
                "        \"quarter\": \"2017-Q3\",\n" +
                "        \"_id\": 53\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"15.77653\",\n" +
                "        \"quarter\": \"2017-Q4\",\n" +
                "        \"_id\": 54\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"16.47121\",\n" +
                "        \"quarter\": \"2018-Q1\",\n" +
                "        \"_id\": 55\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"18.47368\",\n" +
                "        \"quarter\": \"2018-Q2\",\n" +
                "        \"_id\": 56\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"19.97554729\",\n" +
                "        \"quarter\": \"2018-Q3\",\n" +
                "        \"_id\": 57\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"20.43921113\",\n" +
                "        \"quarter\": \"2018-Q4\",\n" +
                "        \"_id\": 58\n" +
                "      },\n" +
                "      {\n" +
                "        \"volume_of_mobile_data\": \"20.53504752\",\n" +
                "        \"quarter\": \"2019-Q1\",\n" +
                "        \"_id\": 59\n" +
                "      }\n" +
                "    ],\n" +
                "    \"_links\": {\n" +
                "      \"start\": \"/api/action/datastore_search?limit=59&resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f\",\n" +
                "      \"next\": \"/api/action/datastore_search?offset=59&limit=59&resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f\"\n" +
                "    },\n" +
                "    \"limit\": 59,\n" +
                "    \"total\": 59\n" +
                "  }\n" +
                "}"
        //result = Result.success(response)
        return data.toGson(DataUsageResponse::class.java)
    }
}