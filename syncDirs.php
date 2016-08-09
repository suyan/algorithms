<?php 

$problems = json_decode(file_get_contents("./problems.json"), true);

foreach ($problems as $problem) {
    $dir = ".";
    if ($problem["source"] == "leetcode") {
        $dir .= "/leetcode";
    } else {
        $lintid = $problem["id"];
        $dir .= "/lintcode";
    }

    $title = $problem["title"];
    $title = str_replace(" ", "-", $title);

    $id = $problem["id"];
    if ($id < 10) {
        $title = "00" . $title;
    } else if ($id >= 10 && $id < 100) {
        $title = "0" . $title;
    }

    // create dir and file
    $dir = $dir . '/' . $title;
    mkdir($dir);
    $java_file = $dir . '/solution.java';
    $cpp_file = $dir . '/solution.cpp';
    if (!file_exists($java_file)) {
        touch($java_file);
    }
    if (!file_exists($cpp_file)) {
        touch($cpp_file);
    }
}

?>