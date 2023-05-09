package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * sort the cityList according to city or province
     * @param param
     * if param=1, sort according to cities,otherwise sort by province
     * @return
     * return sorted cityList
     */
    public List<City> getCities(int param) {
        List<City> cityList = cities;

        if(param==1){
            Collections.sort(cityList);
        }

        else{

            Collections.sort(cityList, new Comparator<City>() {
                        @Override
                        public int compare(City city, City t1) {
                            return city.getProvinceName().compareTo(t1.getProvinceName());
                        }
                    }
            );
        }
        return cityList;
    }


    //  Delete city method

    /**
     * this method delete city
     * @param city
     * city to be deleted
     */
    public void delete(City city){

        if(!cities.contains(city)){
            throw  new IllegalArgumentException();
        }

        else{

            cities.remove(city);
        }
    }

    /**
     * count the number of cities
     * @return
     * return total number of cities
     */
    public int count()
    {
        return cities.size();
    }


}
