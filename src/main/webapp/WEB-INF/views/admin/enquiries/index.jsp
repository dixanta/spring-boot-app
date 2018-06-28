<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Enquiries!</h1>
</div>

<div class="pull-right">
    <p>
        <a href="javascript:void(0)" id="add-btn" class="btn btn-xs btn-primary">
            <span class="glyphicon glyphicon-plus"></span>
        </a>
    </p>
</div>

<div>
    <form id="search-form">
        <h3>Search Form</h3>
        <div class="row">
            <div class="row">
                <div class="col-lg-6">
                    <div class="input-group">
                        <input type="text" id="search-text" name="q" required="required" class="form-control" placeholder="Search for...">
                        <span class="input-group-btn">
                            <button id="search-btn" class="btn btn-default" type="submit">Go!</button>
                        <a href="javascript:void(0)" id="clear-btn" class="btn btn-primary">Clear</a>
                        </span>
                        
                        
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
            </div><!-- /.row -->
        </div>
    </form>
</div>
<table id="enquiry-table" class="table">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Contact No</th>
            <th>Interested Course</th>
            <th>Enquiry Date</th>
        </tr>
    </thead>
    <tbody></tbody>
</table>



<!-- Modal -->
<div class="modal fade" id="enquiry-dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modal-title"></h4>
            </div>
            <form id="enquiry-form">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>First Name</label>
                                <input type="text" name="firstName" id="first-name" class="form-control" required="required"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Last Name</label>
                                <input type="text" name="lastName" id="last-name" class="form-control" required="required"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" name="email" id="email" class="form-control" required="required"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Contact No</label>
                                <input type="text" name="contactNo" id="contact-no" class="form-control" required="required"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Course</label>
                                <select name="course.id" id="select-course-id" class="form-control" required="required">
                                    <option value="">Select Course</option>
                                </select>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Status</label>
                                <label>
                                    <input type="checkbox" id="enquiry-status" name="status"/>
                                    Active</label>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="modal-footer">
                    <input type="hidden" id="enquiry-id" name="id"/>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                    <button type="submit" id="save-btn" class="btn btn-success">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>

    function resetTable(rows){
        var $enquiryTable = $("#enquiry-table");
        var $tbody = $enquiryTable.find('tbody');
        $tbody.find('tr').remove();
        renderRow(rows,$tbody);
    }
    function loadData() {
        
        // $enquiryTable.append($heading);
        $.getJSON("/admin/enquiries/json", function (res) {
            resetTable(res.data);
        });
    }
    
    function renderRow(rows,$tbody){
        $.each(rows, function (i, row) {

                var $tr = $("<tr/>");
                $("<td/>").html(row.id)
                        .appendTo($tr);
                $("<td/>").html(row.firstName + ' ' + row.lastName)
                        .appendTo($tr);
                $("<td/>").html(row.email)
                        .appendTo($tr);
                $("<td/>").html(row.contactNo)
                        .appendTo($tr);
                $("<td/>").html(row.course.name)
                        .appendTo($tr);
                $("<td/>").html(row.createdDate)
                        .appendTo($tr);
                var $editBtn = $('<a class="btn btn-xs btn-default"/>')
                        .attr('data-title', row.firstName + " " + row.lastName)
                        .attr('data-id', row.id)
                        .html('<span class="glyphicon glyphicon-pencil"/>');
                $editBtn.on('click', function () {
                    edit($editBtn);
                });
                $editBtn.on('click', function () {
                    edit($editBtn);
                });
                var $deleteBtn = $('<a class="btn btn-xs btn-default"/>')
                        .attr('data-id', row.id)
                        .html('<span class="glyphicon glyphicon-trash"/>');
                $deleteBtn.on('click', function () {
                    deleteEnquiry($deleteBtn);
                });
                $("<td/>").append($editBtn).append("&nbsp;")
                        .append($deleteBtn)
                        .appendTo($tr);
                $tbody
                        .append($tr);

            });
    }

    function edit($btn) {
        $id = $btn.attr('data-id');
        $.getJSON('/admin/enquiries/json/' + $id, function (res) {
            var row = res.data;
            var $dialog = $("#enquiry-dialog");
            var $title = $btn.attr('data-title');
            $dialog.find('.modal-title').html('Edit Enquiry of :' + $title);
            $("#first-name").val(row.firstName);
            $("#last-name").val(row.lastName);
            $("#email").val(row.email);
            $("#contact-no").val(row.contactNo);
            $("#select-course-id").val(row.course.id);
            $("#enquiry-status").prop('checked', row.status);
            $("#enquiry-id").val(row.id);
            $dialog.modal();
        });

    }
    function deleteEnquiry($btn) {
        if (confirm('Are you sure to Delete')) {
            $id = $btn.attr('data-id');
            $.post('/admin/enquiries/delete', {id: $id}, function (res) {
                if (res.data) {
                    loadData();
                }
            });
        }
    }
    $(document).ready(function () {

        loadData();
        $.getJSON('/course/json', function (res) {
            var $courseSelect = $("#select-course-id");
            $courseSelect.find('option').remove();
            $courseSelect
                    .append($('<option/>').html('Select Course'));
            $.each(res.data, function (i, row) {
                $option = $('<option/>').val(row.id).text(row.name);
                $option.appendTo($courseSelect);
            });
        });

        $("#add-btn").on('click', function () {
            var $dialog = $("#enquiry-dialog");
            $dialog.find('#modal-title').html('Add Enquiry');
            $("#enquiry-dialog").modal();
            document.forms["enquiry-form"].reset();
            $("#enquiry-id").val(0);
        });

        $("#save-btn").on('click', function () {
            var $formData = $("#enquiry-form").serialize();
            $.post('/admin/enquiries/save', $formData, function (res) {
                console.log(res);
                document.forms["enquiry-form"].reset();
                $("#enquiry-dialog").modal('hide');
                loadData();
            });
            return false;
        });
        $("#search-btn").on('click',function(){
           $.getJSON('/admin/enquiries/search',
               $("#search-form").serialize(),function(res){
                  resetTable(res.data);
                  
           });
           return false;
        });
        
        $("#clear-btn").on('click',function(){
            $("#search-text").val('');
           loadData() ;
        });
    });
</script>
<%@include file="../shared/footer.jsp" %>
