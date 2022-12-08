Vue.component("card-comment", {
template:`
    <div class="media p-3">
        <img
            src="https://picsum.photos/150/150"
            alt="John Doe"
            class="mr-3 mt-3 rounded-circle"
            style="width: 60px"
        />
        <div class="media-body">
            <h4>
                John Doe <small><i>Posted on February 19, 2016</i></small>
            </h4>
            <p>
                Lorem ipsum, dolor sit amet consectetur adipisicing elit.
                Sapiente expedita iste omnis obcaecati sequi, nam beatae optio
                reprehenderit modi deleniti minus accusamus sint sed, fugit
                tempora, ducimus fuga officiis iusto!
            </p>
        </div>
    </div>`,
})