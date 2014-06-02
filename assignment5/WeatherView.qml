import QtQuick 2.0

Rectangle {
    id: page
    width: 800
    height: 1000
    color: "#343434"

    //properties and standard values
    //these will be set by the loader
    property string sunrise: "never"
    property string sunset: "never"
    property string sunriseT: "0"
    property string sunsetT: new Date()
    property string city: "nowhere"
    property string country: "nowhere"
    property double latitude: 0
    property double longitude: 0
    property double currentTemperature: 0 //in C
    property double maximumTemperature: 0 //in C
    property double minimumTemperature: 0 //in C
    property int humidity: 0 //in %
    property double pressure: 0 //in hPa
    property double windSpeed: 0
    property string windSpeedDescription: "nonexistent"
    property double windDirection: 0 //in deg
    property string windDirectionDescription: "nonexistent"
    property string windDirectionAbbreviation: "nonexistent"
    property int cloudLevel: 0 // in %
    property string cloudDescription: "nonexistent" // in %
    property string weatherDescription: "nothing"
    property int weatherCode: 0 //see http://bugs.openweathermap.org/projects/api/wiki/Weather_Condition_Codes

    property string fontColor: "#3d3d3d"
    property double sunAngle: 0 //the sun's Positioner

    property string bgImg: "http://farm1.staticflickr.com/231/483342623_5a4e9bde18_b.jpg"

    // Uncomment this for animation when the temperature changes:
    Behavior on currentTemperature { PropertyAnimation { duration: 2000} }
    Behavior on windDirection { PropertyAnimation { duration: 2000} }
    Behavior on humidity { PropertyAnimation { duration: 2000} }
    Behavior on cloudLevel { PropertyAnimation { duration: 2000} }



    //Go crazy!

    Rectangle {
        id: bg
        x: 5
        y: 5
        width: 250
        height: 230
        color: "#99ffffff"
    }
    Text {
        id: cityComboBox
        y: 8
        color: fontColor
        text: "Select City :"
        anchors.leftMargin: 8
        anchors.left: parent.left
        font.pixelSize: 18
        z: 2
    }

    Text {
        id: temperature
        y: 50
        color: fontColor
        text: "It is currently " + currentTemperature.toFixed(2) + "°C"
        anchors.left: parent.left
        anchors.leftMargin: 8
        font.pixelSize: 18
        z: 2
    }


    Text {
        id: humidityLabel
        y: 85
        color: fontColor
        text: "Humidity : " + humidity + "%"
        anchors.left: parent.left
        anchors.leftMargin: 8
        font.pixelSize: 18
        z: 2
    }

    Text {
        id: cloudLevelLabel
        y: 122
        color: fontColor
        text: "Cloud Level " + cloudLevel + "%"
        anchors.left: parent.left
        anchors.leftMargin: 8
        font.pixelSize: 18
        z: 2
    }

    Text {
        id: windDirectionLabel
        y: 158
        color: fontColor
        text: "Wind Direction :"
        anchors.right: text1.right
        anchors.left: parent.left
        anchors.leftMargin: 8
        font.pixelSize: 18
        z: 2
    }

    Image {
        id: image2
        x: 178
        y: 143
        width: 50
        height: 50
        z: 101
        rotation: windDirection.toFixed(0)
        fillMode: Image.PreserveAspectFit
        source: "images/windDirection.svg"
    }


    Image {
        id: image1
        z: -10
        anchors.top: parent.top
        anchors.left: parent.left
        width: page.width
        height: page.height
        fillMode: Image.PreserveAspectCrop
        verticalAlignment: Image.Center
        horizontalAlignment: Image.Center
        source: bgImg

    }

    Text {
        id: text1
        x: 196
        y: 126
        text: qsTr("N")
        font.bold: true
        font.pixelSize: 16
    }

    Text {
        id: text2
        x: 225
        y: 158
        text: qsTr("E")
        font.pixelSize: 16
        font.bold: true
    }

    Text {
        id: text3
        x: 163
        y: 158
        text: qsTr("W")
        font.pixelSize: 16
        font.bold: true
    }

    Text {
        id: text4
        x: 197
        y: 189
        text: qsTr("S")
        font.pixelSize: 16
        font.bold: true
    }

//    Text {
//        id: sunriseLabel
//        x: 100
//        y: 250
//        text: sunriseT
//        font.pixelSize: 16
//        font.bold: true
//    }
//    Text {
//        id: sunsetLabel
//        x: 100
//        y: 270
//        text: sunsetT
//        font.pixelSize: 16
//        font.bold: true
//    }
//    Text {
//        id: currentTimeLabel
//        x: 100
//        y: 290
//        text: new Date()
//        font.pixelSize: 16
//        font.bold: true
//    }
}
