function getWeatherInformation(latitude, longitude) {
  if ((typeof(latitude) !== "string") && (typeof(longitude) !== "string")) {
    latitude = document.getElementById("latitude").value;
    longitude = document.getElementById("longitude").value;
  }

  if ((latitude === "") || (longitude === "")) {
    alert("Incomplete fields");
    return false;
  }

  const request = new XMLHttpRequest();
  request.open("GET", "rest/weather?latitude=" + latitude + "&longitude=" + longitude, true);
  request.setRequestHeader("Content-Type", "application/json");
  request.send();
  request.onreadystatechange = (e) => {
    if (request.readyState === 4 && request.status === 200) {
      const response = JSON.parse(request.responseText);

      if (response.weatherObservation === null) {
        alert("No weather information found. Specify a different location");
        return false;
      }

      const table = document.getElementById("weatherTable");
      const row = table.insertRow(1);

      const countryCode = row.insertCell(0);
      const stationName = row.insertCell(1);
      const weatherCondition = row.insertCell(2);
      const temperature = row.insertCell(3);
      const windSpeed = row.insertCell(4);
      const windDirection = row.insertCell(5);
      const humidity = row.insertCell(6);
      const date = row.insertCell(7);

      countryCode.innerHTML = response.weatherObservation.countryCode;
      stationName.innerHTML = response.weatherObservation.stationName;
      weatherCondition.innerHTML = response.weatherObservation.weatherCondition;
      temperature.innerHTML = response.weatherObservation.temperature;
      windSpeed.innerHTML = response.weatherObservation.windSpeed;
      windDirection.innerHTML = response.weatherObservation.windDirection;
      humidity.innerHTML = response.weatherObservation.humidity;
      date.innerHTML = response.weatherObservation.datetime;

      localStorage.setItem("latitude", latitude);
      localStorage.setItem("longitude", longitude);
    }
  }
}

function getLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
  } else {
    alert("Geolocation is not supported by this browser.");
  }
}

function showPosition(position) {
  const latitude = document.getElementById("latitude");
  const longitude = document.getElementById("longitude");

  const previousLatitude = localStorage.getItem("latitude");
  const previousLongitude = localStorage.getItem("longitude");
  if ((previousLatitude === null) || (previousLongitude === null)) {
    latitude.value = position.coords.latitude;
    longitude.value = position.coords.longitude;
  } else {
    latitude.value = previousLatitude;
    longitude.value = previousLongitude;
  }

  getWeatherInformation(latitude.value, longitude.value);
}