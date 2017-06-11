<%@include file="../init.jsp" %>

           <section class="main">
           		<h1>RFSAC Event Calender</h1>
                <div class="custom-calendar-wrap check-cal-test">
                    <div id="custom-inner" class="custom-inner">
                        <div class="custom-header clearfix">
                       
                            <nav>
                                <span id="custom-prev" class="custom-prev"></span>
                                <span id="custom-next" class="custom-next"></span>
                            </nav>
                            <h2 id="custom-month" class="custom-month"></h2>
                            <h3 id="custom-year" class="custom-year"></h3>
                        </div>
                        <div id="calendar" class="fc-calendar-container"></div>
                    </div>
                </div>
                <div class="res-arrow"><a href="/web/guest/rfsac-event-calendar"><img src="/RFS-V1-theme/images/arrow.jpg" width="26" height="26"></a></div>
            </section>  
        <%--Remove this script due to Click on Menu icon once when it's clcik on menu icon to closed and it's reopen Menu--%>
        <%-- <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script> --%>
        <script src="<%=request.getContextPath()%>/js/jquery.calendario.js"></script>
        <script type="text/javascript"> 
            $(function() {
                var pop_title = '', pop_content = '';
                $(document).popover({
                    delay: { show: 10, hide: 50 },
                    html: true,
                    trigger: 'hover',
                    selector: 'div.fc-content',
                    placement: 'auto',
                    content: function() {
                                return pop_content;
                             },
                    title: function() {
                                return pop_title;
                           },
                    container: 'body'
                });
                var transEndEventNames = {
                        'WebkitTransition' : 'webkitTransitionEnd',
                        'MozTransition' : 'transitionend',
                        'OTransition' : 'oTransitionEnd',
                        'msTransition' : 'MSTransitionEnd',
                        'transition' : 'transitionend'
                    },
                    transEndEventName = transEndEventNames[ Modernizr.prefixed( 'transition' ) ],
                    $wrapper = $( '#custom-inner' ),
                    $calendar = $( '#calendar' ),
                    cal = $calendar.calendario({
                        onDayMouseenter : function( $el, data, dateProperties ) {
                            if( data.content.length > 0 ) {
                                pop_title = dateProperties.monthname + ' ' + dateProperties.day + ', ' + dateProperties.year;
                                pop_content = data.content.join('');
                                cal.feed(logFeed);
                            }
                        },
                        /* onDayClick : function( $el, $content, dateProperties ) {
                        	console.log("day click");
                        	return false;
                        }, */
                        caldata : ${events},
                        events: 'mouseenter',
                        displayWeekAbbr : true,
                        fillEmpty: true
                    }),
                    $month = $( '#custom-month' ).html( cal.getMonthName() ),
                    $year = $( '#custom-year' ).html( cal.getYear() );

                $( '#custom-next' ).on( 'click', function() {
                    cal.gotoNextMonth( updateMonthYear );
                } );
                $( '#custom-prev' ).on( 'click', function() {
                    cal.gotoPreviousMonth( updateMonthYear );
                } );

                function updateMonthYear() {                
                    $month.html( cal.getMonthName() );
                    $year.html( cal.getYear() );
                }

                function logFeed( data ) {              
                    console.log(data);
                }
                
                /* function pageRedirect(url){
	
                	window.open(url,"_blank");
                }
                $(document).on("click","#calendar .fc-past",function(){
                	var _date = $(this).find(".fc-date").html() +","+$("#custom-month").html() +","+$("#custom-year").html();
                	//console.log( $(this).find(".fc-date").html() +", "+ $("#custom-month").html() +", "+ $("#custom-year").html() );
                	pageRedirect("/web/guest/rfsac-event-calendar?date="+_date);
                });
                
                $(document).on("click","#calendar .fc-today",function(){
                	var _date=$(this).find(".fc-date").html() +", "+ $("#custom-month").html() +", "+ $("#custom-year").html();
                	//console.log( $(this).find(".fc-date").html() +", "+ $("#custom-month").html() +", "+ $("#custom-year").html() );
                	//window.open("http://www.google.com","_blank");
                	pageRedirect("/web/guest/rfsac-event-calendar?date="+_date);
                });
                
                $(document).on("click","#calendar .fc-future",function(){
                	var _date=$(this).find(".fc-date").html() +", "+ $("#custom-month").html() +", "+ $("#custom-year").html();
                	//console.log( $(this).find(".fc-date").html() +", "+ $("#custom-month").html() +", "+ $("#custom-year").html() );
                	//window.open("http://www.google.com","_blank");
                	pageRedirect("/web/guest/rfsac-event-calendar?date="+_date);
                }); */
                
                

            });
        </script>