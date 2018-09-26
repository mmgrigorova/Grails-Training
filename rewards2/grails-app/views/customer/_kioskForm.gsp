<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <asset:image src="banner.png"/>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-5 offset-sm-1">
            <h4>Welcome back, Mike.</h4>

            <p>You have 3 points</p>
        </div>

        <div class="col-sm-6">
            <g:textField name="phone" class="form-control" placeholder="Enter your cell number to checkin"/>

            <div class="row" style="height: 20px"></div>

            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="1" onclick="padkey(this.value)"/>
                </div>

                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="2" onclick="padkey(this.value)"/>
                </div>

                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="3" onclick="padkey(this.value)"/>
                </div>
            </div>

            <div class="row" style="height: 20px"></div>

            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="4" onclick="padkey(this.value)"/>
                </div>

                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="5" onclick="padkey(this.value)"/>
                </div>

                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="6" onclick="padkey(this.value)"/>
                </div>
            </div>

            <div class="row" style="height: 20px"></div>

            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="7" onclick="padkey(this.value)"/>
                </div>

                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="8" onclick="padkey(this.value)"/>
                </div>

                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="9" onclick="padkey(this.value)"/>
                </div>
            </div>

            <div class="row" style="height: 20px"></div>

            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-danger btn-lg btn-block" type="button" name="pad" value="Del"/>
                </div>

                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="0" onclick="padkey(this.value)"/>
                </div>

                <div class="col-sm-4">
                    <input class="btn btn-success btn-lg btn-block" type="button" name="pad" value="Go"/>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- pad button script -->
<script> function padkey(num) {
    var txt=document.getElementById("phone").value;
    txt=txt + num;
    document.getElementById("phone").value=txt;
}
</script>