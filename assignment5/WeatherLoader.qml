import QtQuick 2.2
import QtQuick.XmlListModel 2.0

//Touch at your own peril!

Item {

    property string city: "Aachen, de"
    property var weatherView
    property string error

    property string flickrApiKey: "62c1feffd70264fb83b75f79867e0781"
    property string imgUrl: ""
    property int limit: 50
    property int i: 0

    XmlListModel {
//        property QStringList cityName: city.split(",")
        id: photo
        source: "https://api.flickr.com/services/rest/?method=flickr.photos.search&extras=url_l&privacy_filter=1&per_page="+limit.toString()+"&sort=relevance&api_key="+flickrApiKey+"&text=" + city.substring(0,city.length-4) + ", city"
        query: "/rsp/photos/photo"
        XmlRole {
            name: "xml_url"
            query: "@url_l/string()"
        }

        XmlRole {
            name: "xml_id"
            query: "@id/string()"
        }

        XmlRole {
            name: "xml_secret"
            query: "@secret/string()"
        }

        XmlRole {
            name: "xml_farm"
            query: "@farm/string()"
        }

        XmlRole {
            name: "xml_server"
            query: "@server/string()"
        }

        onStatusChanged:
        {
            if(status === XmlListModel.Ready && count >= 1)
            {

                console.log("flickr "+count+"\n"+source+"\n");

                for (; i<limit; i++)
                {
                    imgUrl = get(i).xml_url
                    console.log(i.toString()+", "+imgUrl+" \n")
                    if (imgUrl.length != 0)
                    {
                        weatherView.bgImg = imgUrl
                        i++
                        if (i==limit-1) {i=0;}
                        break
                    }
                    if (i==limit-1) {i=0;}
                }
            }

            if(status == XmlListModel.Error)
            {
                return error = errorString();
            }
            else if (status == XmlListModel.Ready)
            {
                error = photo.count === 0 ? "Error loading photos (invalid city name?)" : "";
            }
        }
    }

    XmlListModel {
        id: weather
        source: "http://api.openweathermap.org/data/2.5/weather?mode=xml&units=metric&q=" + city
        query: "/current"

        XmlRole {
            name: "xml_city"
            query: "city/@name/string()"
        }

        XmlRole {
            name: "xml_country"
            query: "city/country/string()"
        }

        XmlRole {
            name: "xml_latitude"
            query: "city/coord/@lat/string()"
        }

        XmlRole {
            name: "xml_longitude"
            query: "city/coord/@lon/string()"
        }

        XmlRole {
            query: "temperature/@value/number()"
            name: "xml_currentTemperature"

        }
        XmlRole {
            query: "temperature/@max/number()"
            name: "xml_maximumTemperature"
        }
        XmlRole {
            query: "temperature/@min/number()"
            name: "xml_minimumTemperature"
        }

        XmlRole {
            query: "humidity/@value/number()"
            name: "xml_humidity"
        }

        XmlRole {
            query: "pressure/@value/number()"
            name: "xml_pressure"
        }

        XmlRole {
            query: "wind/speed/@value/number()"
            name: "xml_windSpeed"
        }

        XmlRole {
            query: "wind/speed/@name/string()"
            name: "xml_windSpeedDescription"
        }

        XmlRole {
            query: "wind/direction/@value/number()"
            name: "xml_windDirection"
        }

        XmlRole {
            query: "wind/direction/@name/string()"
            name: "xml_windDirectionDescription"
        }

        XmlRole {
            query: "wind/direction/@code/string()"
            name: "xml_windDirectionAbbreviation"
        }
        XmlRole {
            query: "clouds/@value/number()"
            name: "xml_cloudLevel"
        }

        XmlRole {
            query: "clouds/@name/string()"
            name: "xml_cloudDescription"
        }

        XmlRole {
            name: "xml_sunrise"
            query: "city/sun/@rise/string()"
        }
        XmlRole {
            name: "xml_sunset"
            query: "city/sun/@set/string()"
        }
        XmlRole {
            name: "xml_weatherCode"
            query: "weather/@number/number()"
        }
        XmlRole {
            name: "xml_weatherDescription"
            query: "weather/@value/string()"
        }

        onStatusChanged:
        {
            if(status === XmlListModel.Ready && count >= 1)
            {
                weatherView.sunset = Qt.formatDateTime(get(0).xml_sunset, "h:mm")
                weatherView.sunrise = Qt.formatDateTime(get(0).xml_sunrise, "h:mm")
                weatherView.sunsetT = get(0).xml_sunset
                weatherView.sunriseT = get(0).xml_sunrise
                weatherView.city =  get(0).xml_city
                weatherView.country = get(0).xml_country
                weatherView.latitude = get(0).xml_latitude
                weatherView.longitude = get(0).xml_longitude
                weatherView.currentTemperature = get(0).xml_currentTemperature
                weatherView.maximumTemperature =  get(0).xml_maximumTemperature
                weatherView.minimumTemperature = get(0).xml_minimumTemperature
                weatherView.humidity = get(0).xml_humidity
                weatherView.pressure = get(0).xml_pressure
                weatherView.windSpeed = get(0).xml_windSpeed
                weatherView.windSpeedDescription = get(0).xml_windSpeedDescription
                weatherView.windDirection = get(0).xml_windDirection
                weatherView.windDirectionDescription = get(0).xml_windDirectionDescription
                weatherView.windDirectionAbbreviation = get(0).xml_windDirectionAbbreviation
                weatherView.cloudLevel = get(0).xml_cloudLevel
                weatherView.cloudDescription = get(0).xml_cloudDescription
                weatherView.weatherCode = get(0).xml_weatherCode
                weatherView.weatherDescription = get(0).xml_weatherDescription
            }

            if(status == XmlListModel.Error)
            {
                return error = errorString();
            }
            else if (status == XmlListModel.Ready)
            {
                error = weather.count === 0 ? "Error loading weather (invalid city name?)" : "";
            }
        }
    }
}
