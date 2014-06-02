import QtQuick 2.2
import QtQuick.Controls 1.2



Rectangle
{
    color: "#333333"
    width: 600
    height: 400

    ComboBox {
        id: comboBox1
        x: 122
        y: 166
        z: 1001
        anchors.top: parent.top
        anchors.topMargin: 8
        model: [ "Aachen, de", "Berlin, de", "London, uk", "Sidney, au", "Stockholm, se", "Los Angeles, us", "Trento, it", "Taipei, tw" ]
        onCurrentIndexChanged:{
            if (comboBox1.currentText!="") loader.city = comboBox1.currentText; else loader.city = "Aachen, de"}
    }


    WeatherLoader {
        id: loader
        anchors.rightMargin: -94
        anchors.bottomMargin: 0
        anchors.leftMargin: 94
        anchors.topMargin: 0
        anchors.fill: parent
        city: "Aachen, de"
        weatherView: weatherView
        onCityChanged: {console.log(city);}

    }

    Text {
        anchors.horizontalCenter: parent.horizontalCenter
        anchors.verticalCenter: parent.verticalCenter

        text: loader.error
        color: "#d3d3d3"
        font.pointSize: 30
        z: 1000
    }

    WeatherView {
            id: weatherView
            x: 30
            anchors.fill: parent
            color: "#00000000"
    }

}
