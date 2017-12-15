alert("sec hi");
console.log("sam");
$(document).ready(function(){
    alert("sam");
    var samTest="${yourregisteredCar}";
    debugger;
	var DisplayRegisteredCarView=Backbone.View.extend({
		
		
		template:Handlebars.compile($("#configTest").html()),
		testArray:[],
		
		initialize: function(options)
		{
		this.testArray=options.responsedata;
		//this.render();
		},
		events:
			{
			//"click #idvalue":"functionName"
			},
			
			render:function()
			{
				this.$el.append(this.template());
				var samtest=this.response;
			},
			
			addValue:function()
			{
				
			} 
	});
	
	var displayRegisteredCarView= new DisplayRegisteredCarView({
		el: "#bodyelement",
		responsedata:test
	});
	
	displayRegisteredCarView.render();
});