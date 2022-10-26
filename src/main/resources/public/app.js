var autoRefreshIntervalId = null;

function generateTimeslots(){
  const slots = [];
  for(let cnt=0; cnt<24; cnt++){
    slots.push(`H ${cnt.toString().padStart(2, 0)}:00`);
  }
  return slots;
}

function generateEmptyData(robots, timeSlots){
  return [{
    z: Array(robots.length).fill(Array(timeSlots.length).fill(0)),
    x: timeSlots,
    y: robots,
    type: 'heatmap',
    hoverongaps: false,
    showscale:false
  }];
};

function renderHeatMap(input){
  const timeSlots= generateTimeslots();
  const robots = input.robotsList.map(robot => robot.name).sort().reverse(); //generateRobots(15);
  const robotsReverseIdx = robots.reduce((ri, robot, idx) => {ri[robot]=idx; return ri;}, {});

  // const numOfJobs = 25;
  // const allocation = [];
  // for(let robot=0; robot<robots.length; robot++){
  //   const roboSlot = [];
  //   for(let slot=0; slot<=timeSlots.length; slot++){
  //     roboSlot.push(getRandomJob(numOfJobs));
  //   }
  //   allocation.push(roboSlot);
  // }


  // var data = [
  //   {
  //     z: [[1, null, 30, 50, 1], [20, 1, 60, 80, 30], [30, 60, 1, -10, 20]],
  //     x: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'],
  //     y: ['Bot 001', 'Bot 002', 'Bot 003'],
  //     type: 'heatmap',
  //     hoverongaps: false
  //   }
  // ];



  // var data = [
  //   {
  //     z: allocation.reverse(),
  //     x: timeSlots,
  //     y: robots,
  //     type: 'heatmap',
  //     hoverongaps: false,
  //     showscale:false
  //   }
  // ];




  const jobNames = Array.from(input.jobList.reduce((s, jl)=>(s.add(jl.parentJob)), new Set())).sort().reduce((ri, j, idx) => {ri[j]=idx; return ri;}, {});
  // console.log(jobNames);
  const singleDayAllocation = input.jobList.filter(job => (job.startDayOfWeek === 'MONDAY' && job.startDayOfWeek === job.endDayOfWeek));
//  const emptyAllocations = Array(robots.length).fill(Array(timeSlots.length).fill(null));
  const emptyAllocations = [];
  for (let rc=0; rc<robots.length; rc++){
    emptyAllocations.push(Array(timeSlots.length).fill(null));
  }

  //console.log(jobNames, robotsReverseIdx, emptyAllocations)
  const allAllocations = singleDayAllocation.reduce(function(acc, job){
    let startTime = parseInt(job.startDateTime.split(":")[0]);
    console.log(job.robots.name, job.timeRange, job.parentJob, robotsReverseIdx[job.robots.name],startTime);
    for(let cnt=0; cnt<job.timeRange;cnt++ ){
      acc[robotsReverseIdx[job.robots.name]][startTime+cnt] = jobNames[job.parentJob];
    }
    return acc;
  },emptyAllocations);
  //console.log(allAllocations);

  //const
  //data = generateEmptyData(robots, timeSlots);data = [
  data =[{
    z: allAllocations,
    x: timeSlots,
    y: robots,
    type: 'heatmap',
    hoverongaps: false,
    showscale:false
  }
  ];


  var layout = {
//    title: 'E5 Scheduler',
    annotations: [],
    xaxis: {
      ticks: 'xxx',
      side: 'top'
    },
    yaxis: {
      ticks: '',
      ticksuffix: ' ',
    },
    width: 1280,
    height: 720,
    autosize: false
  };
  const config = {
    displayModeBar: false
  };
  Plotly.newPlot('heat-map', data, layout, config);
}


function refreshTimeTable() {
  $.getJSON("/timeTable", function (timeTable) {

    renderHeatMap(timeTable);
//
    refreshSolvingButtons(timeTable.solverStatus != null && timeTable.solverStatus !== "NOT_SOLVING");
    $("#score").text("Score: " + (timeTable.score == null ? "?" : timeTable.score));
//
//    const timeTableByRoom = $("#timeTableByRoom");
//    timeTableByRoom.children().remove();
//    const timeTableByTeacher = $("#timeTableByTeacher");
//    timeTableByTeacher.children().remove();
//    const timeTableByStudentGroup = $("#timeTableByStudentGroup");
//    timeTableByStudentGroup.children().remove();
//    const unassignedLessons = $("#unassignedLessons");
//    unassignedLessons.children().remove();
//
//    const theadByRoom = $("<thead>").appendTo(timeTableByRoom);
//    const headerRowByRoom = $("<tr>").appendTo(theadByRoom);
//    headerRowByRoom.append($("<th style='width:200;'>Timeslot </th>"));
//    $.each(timeTable.robotsList, (index, robot) => {
//      headerRowByRoom
//        .append($("<th style='width:200;'/>")
//          .append($("<span/>").text(robot.name))
//          //.append($(`<button type="button" class="ml-2 mb-1 btn btn-light btn-sm p-1"/>`)
//            //.append($(`<small class="fas fa-trash"/>`)
//            //).click(() => deleteRoom(room)))
//            );
//    });
//
//    const theadByTeacher = $("<thead>").appendTo(timeTableByTeacher);
//    const headerRowByTeacher = $("<tr>").appendTo(theadByTeacher);
//    headerRowByTeacher.append($("<th>Timeslot</th>"));
//  /*  const teacherList = [...new Set(timeTable.lessonList.map(lesson => lesson.teacher))];
//    $.each(teacherList, (index, teacher) => {
//      headerRowByTeacher
//        .append($("<th/>")
//          .append($("<span/>").text(teacher)));
//    });*/
//    const theadByStudentGroup = $("<thead>").appendTo(timeTableByStudentGroup);
//    const headerRowByStudentGroup = $("<tr>").appendTo(theadByStudentGroup);
//    headerRowByStudentGroup.append($("<th>Timeslot</th>"));
//   /* const studentGroupList = [...new Set(timeTable.lessonList.map(lesson => lesson.robotsGroup))];
//    $.each(studentGroupList, (index, studentGroup) => {
//      headerRowByStudentGroup
//        .append($("<th/>")
//          .append($("<span/>").text(studentGroup)));
//    });
//*/
//    const tbodyByRoom = $("<tbody>").appendTo(timeTableByRoom);
//    const tbodyByTeacher = $("<tbody>").appendTo(timeTableByTeacher);
//   const tbodyByStudentGroup = $("<tbody>").appendTo(timeTableByStudentGroup);
//    $.each(timeTable.timeslotList, (index, timeslot) => {
//      const rowByRoom = $("<tr>").appendTo(tbodyByRoom);
//      rowByRoom
//        .append($(`<th class="align-middle"/>`)
//          .append($("<span/>").text(`
//                    ${timeslot.startDayOfWeek.charAt(0) + timeslot.startDayOfWeek.slice(1).toLowerCase()}
//                    ${moment(timeslot.startTime, "HH:mm:ss").format("HH:mm")}
//                    -
//                    ${moment(timeslot.endTime, "HH:mm:ss").format("HH:mm")}
//                `)
//            //.append($(`<button type="button" class="ml-2 mb-1 btn btn-light btn-sm p-1"/>`)
//              //.append($(`<small class="fas fa-trash"/>`)
//             // ).click(() => deleteTimeslot(timeslot))
//             // )
//              ));
//      $.each(timeTable.robotsList, (index, room) => {
//        rowByRoom.append($("<td/>").prop("id", `timeslot${timeslot.id}room${room.id}`));
//      });
//
//  const rowByTeacher = $("<tr>").appendTo(tbodyByTeacher);
//      rowByTeacher
//        .append($(`<th class="align-middle"/>`)
//          .append($("<span/>").text(`
//                    ${timeslot.startDayOfWeek.charAt(0) + timeslot.startDayOfWeek.slice(1).toLowerCase()}
//                    ${moment(timeslot.startTime, "HH:mm:ss").format("HH:mm")}
//                    -
//                    ${moment(timeslot.endTime, "HH:mm:ss").format("HH:mm")}
//                `)));
//     /* $.each(teacherList, (index, teacher) => {
//        rowByTeacher.append($("<td/>").prop("id", `timeslot${timeslot.id}teacher${convertToId(teacher)}`));
//      });*/
//
//      const rowByStudentGroup = $("<tr>").appendTo(tbodyByStudentGroup);
//      rowByStudentGroup
//        .append($(`<th class="align-middle"/>`)
//          .append($("<span/>").text(`
//                    ${timeslot.startDayOfWeek.charAt(0) + timeslot.startDayOfWeek.slice(1).toLowerCase()}
//                    ${moment(timeslot.startTime, "HH:mm:ss").format("HH:mm")}
//                    -
//                    ${moment(timeslot.endTime, "HH:mm:ss").format("HH:mm")}
//                `)));
//     /* $.each(studentGroupList, (index, studentGroup) => {
//        rowByStudentGroup.append($("<td/>").prop("id", `timeslot${timeslot.id}studentGroup${convertToId(studentGroup)}`));
//      });*/
//    });
//
//    $.each(timeTable.jobList, (index, job) => {
//
//      const color = pickColor(job.parentJob);
//      const lessonElementWithoutDelete = $(`<div class="card lesson" style="background-color: ${color}"/>`)
//        .append($(`<div class="card-body"/>`).attr({title:job.parentJob})
//          //.append($(`<h5 class="card-title mb-1"/>`).text(job.parentJob))
//          /*.append($(`<p class="card-text ml-2 mb-1"/>`)
//            .append($(`<em/>`).text(`by ${job.robotsGroup}`)))*/
//         /* .append($(`<small class="ml-2 mt-1 card-text text-muted align-bottom float-right"/>`)
//          .text(job.id))*/
//          /*.append($(`<p class="card-text ml-2"/>`)
//          .text(job.timeslot.dayOfWeek + ' '+ job.timeslot.startTime + ' '+ job.timeslot.endTime))*/
//          );
//      const lessonElement = lessonElementWithoutDelete.clone();
//     /* lessonElement.find(".card-body").prepend(
//        $(`<button type="button" class="ml-2 btn btn-light btn-sm p-1 float-right"/>`)
//          .append($(`<small class="fas fa-trash"/>`)
//          ).click(() => deleteLesson(lesson))
//      );*/
//      if (job.timeslot == null || job.robots == null) {
//        unassignedLessons.append(lessonElement);
//      } else {
//        $(`#timeslot${job.timeslot.id}room${job.robots.id}`).append(lessonElement);
//       // $(`#timeslot${lesson.timeslot.id}teacher${convertToId(lesson.teacher)}`).append(lessonElementWithoutDelete.clone());
//        //$(`#timeslot${lesson.timeslot.id}studentGroup${convertToId(lesson.studentGroup)}`).append(lessonElementWithoutDelete.clone());
//      }
//    });
//
//$('#timeTableByRoom').find('tr').each(function(index, tr) {
//		if(index != 0)
//		{
//			if($(tr).find('td div.card-body').length < 1)
//			$(tr)[0].style.display = 'none';
//		}
//	});

  });

}

function convertToId(str) {
  // Base64 encoding without padding to avoid XSS
  return btoa(str).replace(/=/g, "");
}

function solve() {
  $.post("/timeTable/solve", function () {
    refreshSolvingButtons(true);
  }).fail(function (xhr, ajaxOptions, thrownError) {
    showError("Start solving failed.", xhr);
  });
}

function refreshSolvingButtons(solving) {

  if (solving) {
    $("#solveButton").hide();
    $("#stopSolvingButton").show();
    if (autoRefreshIntervalId == null) {
      autoRefreshIntervalId = setInterval(refreshTimeTable, 2000);
    }
  } else {
    $("#solveButton").show();
    $("#stopSolvingButton").hide();
    if (autoRefreshIntervalId != null) {
      clearInterval(autoRefreshIntervalId);
      autoRefreshIntervalId = null;
    }
  }
}

function stopSolving() {
  $.post("/timeTable/stopSolving", function () {
    refreshSolvingButtons(false);
    refreshTimeTable();
  }).fail(function (xhr, ajaxOptions, thrownError) {
    showError("Stop solving failed.", xhr);
  });
}

function showError(title, xhr) {
  const serverErrorMessage = !xhr.responseJSON ? `${xhr.status}: ${xhr.statusText}` : xhr.responseJSON.message;
  console.error(title + "\n" + serverErrorMessage);
  const notification = $(`<div class="toast" role="alert" aria-live="assertive" aria-atomic="true" style="min-width: 30rem"/>`)
      .append($(`<div class="toast-header bg-danger">
                 <strong class="mr-auto text-dark">Error</strong>
                 <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                   <span aria-hidden="true">&times;</span>
                 </button>
               </div>`))
      .append($(`<div class="toast-body"/>`)
          .append($(`<p/>`).text(title))
          .append($(`<pre/>`)
              .append($(`<code/>`).text(serverErrorMessage))
          )
      );
  $("#notificationPanel").append(notification);
  notification.toast({delay: 30000});
  notification.toast('show');
}

$(document).ready(function () {
  $.ajaxSetup({
    headers: {
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    }
  });
  // Extend jQuery to support $.put() and $.delete()
  jQuery.each(["put", "delete"], function (i, method) {
    jQuery[method] = function (url, data, callback, type) {
      if (jQuery.isFunction(data)) {
        type = type || callback;
        callback = data;
        data = undefined;
      }
      return jQuery.ajax({
        url: url,
        type: method,
        dataType: type,
        data: data,
        success: callback
      });
    };
  });

  $("#refreshButton").click(function () {
    refreshTimeTable();
  });
  $("#solveButton").click(function () {
    solve();
  });
  $("#stopSolvingButton").click(function () {
    stopSolving();
  });
  $("#addLessonSubmitButton").click(function () {
    addLesson();
  });
  $("#addTimeslotSubmitButton").click(function () {
    addTimeslot();
  });
  $("#addRoomSubmitButton").click(function () {
    addRoom();
  });

  refreshTimeTable();
});

// ****************************************************************************
// TangoColorFactory
// ****************************************************************************

const SEQUENCE_1 = [0x8AE234, 0xFCE94F, 0x729FCF, 0xE9B96E, 0xAD7FA8];
const SEQUENCE_2 = [0x73D216, 0xEDD400, 0x3465A4, 0xC17D11, 0x75507B];

var colorMap = new Map;
var nextColorCount = 0;

function pickColor(object) {
  let color = colorMap[object];
  if (color !== undefined) {
    return color;
  }
  color = nextColor();
  colorMap[object] = color;
  return color;
}

function nextColor() {
  let color;
  let colorIndex = nextColorCount % SEQUENCE_1.length;
  let shadeIndex = Math.floor(nextColorCount / SEQUENCE_1.length);
  if (shadeIndex === 0) {
    color = SEQUENCE_1[colorIndex];
  } else if (shadeIndex === 1) {
    color = SEQUENCE_2[colorIndex];
  } else {
    shadeIndex -= 3;
    let floorColor = SEQUENCE_2[colorIndex];
    let ceilColor = SEQUENCE_1[colorIndex];
    let base = Math.floor((shadeIndex / 2) + 1);
    let divisor = 2;
    while (base >= divisor) {
      divisor *= 2;
    }
    base = (base * 2) - divisor + 1;
    let shadePercentage = base / divisor;
    color = buildPercentageColor(floorColor, ceilColor, shadePercentage);
  }
  nextColorCount++;
  return "#" + color.toString(16);
}

function buildPercentageColor(floorColor, ceilColor, shadePercentage) {
  let red = (floorColor & 0xFF0000) + Math.floor(shadePercentage * ((ceilColor & 0xFF0000) - (floorColor & 0xFF0000))) & 0xFF0000;
  let green = (floorColor & 0x00FF00) + Math.floor(shadePercentage * ((ceilColor & 0x00FF00) - (floorColor & 0x00FF00))) & 0x00FF00;
  let blue = (floorColor & 0x0000FF) + Math.floor(shadePercentage * ((ceilColor & 0x0000FF) - (floorColor & 0x0000FF))) & 0x0000FF;
  return red | green | blue;
}
