 var chart;
var chartData = [];



// generate some random data, quite different range
function generateChartData() {
    var firstDate = new Date();
    firstDate.setDate(firstDate.getDate() - 50);

    for (var i = 0; i < 50; i++) {
        var newDate = new Date(firstDate);
        newDate.setDate(newDate.getDate() + i);

        var visits = Math.round(Math.random() * 400) + 100;
        var hits = Math.round(Math.random() * 800) + 500;
        var views = visits+hits;

        chartData.push({
            date: newDate,
            hits: hits,
            visits: visits,
            views: views
        });
    }
}

// this method is called when chart is first inited as we listen for "dataUpdated" event
function zoomChart() {
    // different zoom methods can be used - zoomToIndexes, zoomToDates, zoomToCategoryValues
    chart.zoomToIndexes(10, 20);
}